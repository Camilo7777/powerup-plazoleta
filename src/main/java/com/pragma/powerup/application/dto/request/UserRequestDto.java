package com.pragma.powerup.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private Long id;
    private String documentNumber;
    private String fistName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private Long roleId;
}
