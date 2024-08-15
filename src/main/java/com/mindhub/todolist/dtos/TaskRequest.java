package com.mindhub.todolist.dtos;

import com.mindhub.todolist.models.TaskStatus;

import java.util.Objects;

public class TaskRequest {

    private Long user_id;
    private String title;
    private String description;
    private TaskStatus status;
    public TaskRequest() {
    }

    public TaskRequest(Long user_id, String title, String description, TaskStatus status) {
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Long getUserId() {
        return user_id;
    }

    public void setUserId(Long id) {
        this.user_id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskRequest that = (TaskRequest) o;
        return Objects.equals(user_id, that.user_id) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, title, description, status);
    }

    @Override
    public String toString() {
        return "TaskRequest{" +
                "user_id=" + user_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}

