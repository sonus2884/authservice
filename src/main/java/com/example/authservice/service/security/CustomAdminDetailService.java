package com.example.authservice.service.security;


import com.example.authservice.model.Admin;
import com.example.authservice.repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomAdminDetailService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Admin admin = adminRepository.findAdminByEmail(s);

        if (admin == null) {
            throw new UsernameNotFoundException("User Name not found");
        }

        log.info("Admin " + admin.getEmail() + " has Role " + admin.getRole());

        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(admin.getRole());

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add((grantedAuthority));

        log.info("Admin grand " + admin.getEmail() + " has Role " + authorities.get(0));

        return new User(
                admin.getEmail(),
                admin.getPassword(),
                authorities
        );
    }
}
