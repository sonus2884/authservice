package com.example.authservice.service;

import com.example.authservice.dto.AdminDto;
import com.example.authservice.model.Admin;

public interface AdminService {

    Admin registerAdmin(AdminDto adminDto);
}
