package com.mindhub.todolist.services;

import com.mindhub.todolist.dtos.UserDto;
import com.mindhub.todolist.interfaces.UserService;
import com.mindhub.todolist.mappers.UserMapper;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto request) {
        UserEntity createAUser = UserMapper.userDtoToUser(request);
        createAUser = userRepository.save(createAUser);
        return UserMapper.userToUserDto(createAUser);
    }

    @Override
    public UserDto getUser(Long id) throws Exception {
            UserEntity getAUser = userRepository.findById(id).orElse(null);
            if (getAUser == null){
                throw new Exception("Usuario no encontrado: " + id);
            }
        getAUser = userRepository.save(getAUser);
        return UserMapper.userToUserDto(getAUser);
    }

    @Override
    public UserDto updateUser(Long id, UserDto request) throws Exception {
        UserEntity findUser = userRepository.findById(id).orElse(null);
        if (findUser == null){
            throw new Exception("Usuario no encontrado: " + id);
        }
        UserEntity updateAUser = findUser;
        updateAUser.setEmail(request.getEmail());
        updateAUser.setPassword(request.getPassword());
        updateAUser.setUsername(request.getUsername());
        updateAUser = userRepository.save(updateAUser);

        return UserMapper.userToUserDto(updateAUser);
    }

    @Override
    public String deleteUser(Long id) throws Exception {
        UserEntity FindUser = userRepository.findById(id).orElse(null);
        if (FindUser == null){
            throw new Exception("Usuario no encontrado: " + id);
        }
        userRepository.deleteById(id);

        return "Eliminación de usuario exitosa";
    }

    @Override
    public void registerUser(UserDto registrationDto) throws Exception {
        if (userRepository.findByEmail(registrationDto.getEmail()).isPresent())
            throw new RuntimeException("Username already exists");

        UserEntity user = new UserEntity();
        user.setEmail(registrationDto.getEmail());
        user.setUsername(registrationDto.getUsername());
        user.setRol(registrationDto.getRol());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        userRepository.save(user);
    }
}
