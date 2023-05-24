package com.example.e_ticket.service;

import com.example.e_ticket.dao.UserDao;
import com.example.e_ticket.domain.dto.BaseResponse;
import com.example.e_ticket.domain.dto.request.UserPostRequest;
import com.example.e_ticket.domain.dto.response.UserGetResponse;
import com.example.e_ticket.domain.entity.user.UserEntity;
import com.example.e_ticket.domain.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements BaseService<UserPostRequest, BaseResponse<UserGetResponse>> {
    private final UserDao userDao;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public BaseResponse<UserGetResponse> create(UserPostRequest userPostRequest) {
        UserEntity user = modelMapper.map(userPostRequest, UserEntity.class);
        user.setUserRole(UserRole.ADMIN);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            userDao.save(user);
        } catch (Exception e) {
            return BaseResponse.<UserGetResponse>builder()
                    .status(400)
                    .message(userPostRequest.getEmail() + " already exists")
                    .build();
        }

        return BaseResponse.<UserGetResponse>builder()
                .status(200)
                .data(modelMapper.map(user, UserGetResponse.class))
                .message(userPostRequest.getName() + " has been successfully added")
                .build();
    }

    public BaseResponse<UserGetResponse> login(
            String email,
            String password) {

        Optional<UserEntity> userEntityByEmail = userDao.findUserEntityByEmail(email);
        if (userEntityByEmail.isEmpty())
            return BaseResponse.<UserGetResponse>builder()
                    .status(404)
                    .message("User email or password is not correct")
                    .build();


        UserEntity user = userEntityByEmail.get();


        if (passwordEncoder.matches(password, user.getPassword())) {
            if (user.isDeleted()) {
                return BaseResponse.<UserGetResponse>builder()
                        .status(401)
                        .message("User is blocked")
                        .build();
            }
            return BaseResponse.<UserGetResponse>builder()
                    .status(200)
                    .data(modelMapper.map(user, UserGetResponse.class))
                    .message("Successfully signed in")
                    .build();
        }

        return BaseResponse.<UserGetResponse>builder()
                .status(404)
                .message("User email or password is not correct")
                .build();
    }

    @Override
    public BaseResponse<UserGetResponse> getById(UUID id) {
        return BaseResponse.<UserGetResponse>builder()
                .data(modelMapper.map(userDao.findById(id).get(), UserGetResponse.class))
                .build();
    }

    @Override
    public BaseResponse<UserGetResponse> deleteById(UUID id) {
        return null;
    }
}
