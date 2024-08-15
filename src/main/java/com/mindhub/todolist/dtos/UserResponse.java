package com.mindhub.todolist.dtos;

import com.mindhub.todolist.models.Task;

import java.util.ArrayList;
import java.util.List;

public class UserResponse {

    private String username;
    private String password;
    private String email;
    private List<Task> tasks = new ArrayList<>();

    public UserResponse() {
    }

    public UserResponse(String username, String password, String email, List<Task> tasks) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.tasks = tasks;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
