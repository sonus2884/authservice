package com.example.authservice.service;

import com.example.authservice.dto.AdminDto;
import com.example.authservice.exceptions.AdminExistsException;
import com.example.authservice.model.Admin;
import com.example.authservice.repository.AdminRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Admin registerAdmin(AdminDto adminDto) {

        if(adminRepository.findAdminByEmail(adminDto.getEmail()) != null){

            //Admin Account is already found;
            throw new AdminExistsException("Admin with \'" + adminDto.getEmail()+ " \' email already exists");

        }


        Admin admin = new Admin();

        admin.setEmail(adminDto.getEmail());
        admin.setFullName(adminDto.getFullName());
        admin.setPassword(passwordEncoder.encode(adminDto.getPassword()));
        admin.setRole(adminDto.getRole());

        Admin savedAdmin = adminRepository.save(admin);

        return savedAdmin;

    }
}
