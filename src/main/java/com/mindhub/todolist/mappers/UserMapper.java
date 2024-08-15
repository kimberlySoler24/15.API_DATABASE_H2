package com.mindhub.todolist.mappers;

import com.mindhub.todolist.dtos.UserDto;
import com.mindhub.todolist.models.UserEntity;

public class UserMapper {

    public static UserEntity userDtoToUser(UserDto userDto){

        return new UserEntity(userDto.getUsername(), userDto.getPassword(), userDto.getEmail());
    }

    public static UserDto userToUserDto(UserEntity userEntity){

        return new UserDto(userEntity.getUsername(), userEntity.getPassword(), userEntity.getEmail());
    }

}
