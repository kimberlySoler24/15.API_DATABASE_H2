package com.mindhub.todolist.mappers;

import com.mindhub.todolist.dtos.TaskRequest;
import com.mindhub.todolist.models.Task;
import com.mindhub.todolist.models.TaskStatus;

public class TaskMapper {

    public static Task TaskRequestToTask(TaskRequest taskRequest){
        return new Task(taskRequest.getTitle(), taskRequest.getDescription(), taskRequest.getStatus());
    }
}
