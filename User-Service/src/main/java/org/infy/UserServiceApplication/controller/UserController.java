package org.infy.UserServiceApplication.controller;

import jakarta.validation.Valid;
import org.infy.UserServiceApplication.dto.UserRequestDTO;
import org.infy.UserServiceApplication.model.Users;
import org.infy.UserServiceApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    private ResponseEntity<Users> addUser(@RequestBody @Valid UserRequestDTO dto){

        Users user=userService.addUser(dto);

        if(user!=null){
            ResponseEntity response=new ResponseEntity(user,HttpStatus.OK);
            return response;
        }
        return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
    }
}
