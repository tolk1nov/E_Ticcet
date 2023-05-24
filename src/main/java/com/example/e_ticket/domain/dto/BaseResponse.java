package com.example.e_ticket.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponse <T>{
    private int status;
    private String message;
    private T data;
}
