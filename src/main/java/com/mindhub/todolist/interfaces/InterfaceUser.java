package com.mindhub.todolist.interfaces;

import com.mindhub.todolist.dtos.UserRequest;
import com.mindhub.todolist.dtos.UserResponse;

public interface InterfaceUser{
    public UserResponse createUser(UserRequest request) throws Exception;
    public UserResponse getUser(Long id) throws Exception;
    public UserResponse updateUser(Long id, UserRequest request) throws Exception;
    public String DeleteUser(Long id) throws Exception;
}
