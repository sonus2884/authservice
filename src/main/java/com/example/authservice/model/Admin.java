package com.example.authservice.model;

import com.example.authservice.validation.EmailValidate;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EmailValidate
    private String email;

    private String password;

    private String fullName;

    private String role;
}
