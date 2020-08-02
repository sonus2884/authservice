package com.example.authservice.dto;


import com.example.authservice.validation.EmailValidate;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AdminDto {

    @NonNull
    @Size(min = 5)
    private String fullName;

    @NonNull
    @Size(min = 1)
    @EmailValidate
    private String email;

    @NonNull
    @Size(min = 6)
    private String password;

    @NonNull
    private String role;

}
