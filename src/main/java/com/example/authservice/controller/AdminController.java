package com.example.authservice.controller;

import com.example.authservice.dto.AdminDto;
import com.example.authservice.dto.AdminResponseDto;
import com.example.authservice.dto.ResponseDto;
import com.example.authservice.model.Admin;
import com.example.authservice.repository.AdminRepository;
import com.example.authservice.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.aspectj.weaver.Lint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Slf4j
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/admin/register")
    public ResponseDto<AdminResponseDto> registerAdmin(@RequestBody AdminDto adminDto){

        log.info("Received Admin Registration"+adminDto.getEmail());
        Admin savedAdmin = adminService.registerAdmin(adminDto);
        return new ResponseDto<>(
                HttpStatus.OK,
                new AdminResponseDto(savedAdmin.getId(),savedAdmin.getFullName(), savedAdmin.getEmail())
        );

    }

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/allAdmin")
    public List<Admin> getAllAdmin(){

        return adminRepository.findAll();
    }
}
