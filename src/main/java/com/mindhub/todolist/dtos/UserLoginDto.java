package com.mindhub.todolist.dtos;

import java.util.Objects;

public class UserLoginDto {
    private String username;
    private String password;
    private String email;
    public UserLoginDto() {
    }
    public UserLoginDto(String username, String password) {
        this.username = username;
        this.password = password;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLoginDto userDto = (UserLoginDto) o;
        return Objects.equals(username, userDto.username) && Objects.equals(password, userDto.password) && Objects.equals(email, userDto.email);
    }
    @Override
    public int hashCode() {
        return Objects.hash(username, password, email);
    }
    @Override
    public String toString() {
        return "UserDto{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
