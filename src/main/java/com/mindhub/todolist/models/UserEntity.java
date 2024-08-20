package com.mindhub.todolist.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Set<Task> tasks = new HashSet<>();

    private RolEnum rol = RolEnum.USER;

    public UserEntity() {
    }
    public UserEntity(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public RolEnum getRol() {
        return rol;
    }
    public void setRol(RolEnum rol) {
        this.rol = rol;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Set<Task> getTask() {
        return tasks;
    }
    public void addTask(Task task) {
        task.setUsers(this);
        tasks.add(task);
    }
}
