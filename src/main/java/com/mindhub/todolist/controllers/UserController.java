package com.mindhub.todolist.controllers;

import com.mindhub.todolist.dtos.UserDto;
import com.mindhub.todolist.interfaces.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id)throws Exception{
        try {
            UserDto response = userService.getUser(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto request) throws Exception{
        try {
            UserDto response = userService.updateUser(id, request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) throws Exception{
        try {
            String response = userService.deleteUser(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }
    }
    }
