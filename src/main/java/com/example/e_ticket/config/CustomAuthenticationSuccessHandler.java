package com.example.e_ticket.config;

import com.example.e_ticket.domain.entity.user.UserEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_ADMIN")){
                response.sendRedirect("/admin/admin");
                return;
            }
            if (authority.getAuthority().equals("ROLE_USER")){
                UserEntity user = (UserEntity) authentication.getPrincipal();
                request.getSession().setAttribute("userId", user.getId());
                response.sendRedirect("/user/user");
                return;
            }
        }
    }
}
