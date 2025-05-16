package org.infy.UserServiceApplication.service;

import jakarta.validation.Valid;
import org.infy.UserServiceApplication.dto.UserRequestDTO;
import org.infy.UserServiceApplication.model.Users;
import org.infy.UserServiceApplication.repositiory.UserRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Encoder;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepositiory userRepositiory;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${user.authority}")
    private String userAuthority;

    @Value("${admin.authority}")
    private String adminAuthority;

    public Users addUpdate( UserRequestDTO dto) {
        Users user=dto.toUser();
        user.setAuthorities(userAuthority);
        if(userRepositiory.findByContact(dto.getContact()) !=null){
            user.setPassword(passwordEncoder.encode(dto.getPassword()));

        }
        //wallet service, notification email
        return userRepositiory.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
