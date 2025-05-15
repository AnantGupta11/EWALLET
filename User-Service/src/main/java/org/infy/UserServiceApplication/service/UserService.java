package org.infy.UserServiceApplication.service;

import jakarta.validation.Valid;
import org.infy.UserServiceApplication.dto.UserRequestDTO;
import org.infy.UserServiceApplication.model.Users;
import org.infy.UserServiceApplication.repositiory.UserRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepositiory userRepositiory;
    public Users addUser( UserRequestDTO dto) {
        Users users=dto.toUser();
        return userRepositiory.save(users);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
