package com.mindhub.todolist.configuration;

import com.mindhub.todolist.models.TaskStatus;
import com.mindhub.todolist.models.Task;
import com.mindhub.todolist.models.UserList;
import com.mindhub.todolist.repositories.TaskRepository;
import com.mindhub.todolist.repositories.UserToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserToDoListConfiguration {

    @Autowired
    UserToDoListRepository userToDoListRepository;

    @Autowired
    TaskRepository taskRepository;

    @Bean
    public CommandLineRunner initData() {
        return args -> {

            UserList user = new UserList("prueba", "12345", "prueba@gmail.com");
            userToDoListRepository.save(user);

            Task task = new Task("Matematicas", "tarea de matemáticas", TaskStatus.IN_PROGRESS);
            user.addTask(task);
            taskRepository.save(task);
        };
    }
}
