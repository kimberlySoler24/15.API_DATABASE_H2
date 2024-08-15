package com.mindhub.todolist.configuration;

import com.mindhub.todolist.models.TaskStatus;
import com.mindhub.todolist.models.Task;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.TaskRepository;
import com.mindhub.todolist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserToDoListConfiguration {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @Bean
    public CommandLineRunner initData() {
        return args -> {

            UserEntity user = new UserEntity("prueba", "12345", "prueba@gmail.com");
            userRepository.save(user);

            Task task = new Task("Matematicas", "tarea de matemáticas", TaskStatus.IN_PROGRESS);
            user.addTask(task);
            taskRepository.save(task);
        };
    }
}
