package com.mindhub.todolist.interfaces;

import com.mindhub.todolist.dtos.UserDto;

public interface UserService {
    public UserDto createUser(UserDto request);
    public UserDto getUser(Long id) throws Exception;
    public UserDto updateUser(Long id, UserDto request) throws Exception;
    public String deleteUser(Long id) throws Exception;
    public void registerUser(UserDto registrationDto);
}
