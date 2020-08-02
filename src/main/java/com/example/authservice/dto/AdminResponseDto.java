package com.example.authservice.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminResponseDto {

    private Long id;

    private String fullName;

    private String email;


    public AdminResponseDto(Long id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;

    }


}

