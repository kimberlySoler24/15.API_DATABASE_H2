package com.mindhub.todolist.dtos;

import com.mindhub.todolist.models.TaskStatus;
import com.mindhub.todolist.models.UserEntity;

import java.util.Objects;


public class TaskResponse {

    private String title;
    private String description;
    private TaskStatus status;
    public TaskResponse() {
    }

    public TaskResponse( String title, String description, TaskStatus status) {
        this.title = title;
        this.description = description;
        this.status = status;
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
        TaskResponse that = (TaskResponse) o;
        return Objects.equals(title, that.title) && Objects.equals(description, that.description) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, status);
    }

    @Override
    public String toString() {
        return "TaskResponse{" +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}

