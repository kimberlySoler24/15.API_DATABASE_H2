package com.mindhub.todolist.models;

import com.mindhub.todolist.dtos.TaskStatus;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    @OneToMany(mappedBy = "task")
    private Set<UserToDoList> users = new HashSet<>();

    public Task() {
    }

    public Task(Long id, String title, String description, TaskStatus status, Set<UserToDoList> users) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Set<UserToDoList> getUsers() {
        return users;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setUser(Set<UserToDoList> users) {
        this.users = users;
    }
}
