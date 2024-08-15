package com.mindhub.todolist.interfaces;

import com.mindhub.todolist.dtos.TaskRequest;
import com.mindhub.todolist.dtos.TaskResponse;

public interface TaskService {
    public TaskResponse createTask(TaskRequest request) throws Exception;
    public TaskResponse getTask(Long id) throws Exception;
    public TaskResponse updateTask(Long id, TaskRequest request) throws Exception;
    public String DeleteTask(Long id) throws Exception;
}
