package com.mindhub.todolist.controllers;

import com.mindhub.todolist.dtos.UserDto;
import com.mindhub.todolist.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto request) throws Exception{
        try {
            UserDto response = userService.createUser(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }
    }

}
