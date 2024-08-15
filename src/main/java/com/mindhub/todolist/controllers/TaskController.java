package com.mindhub.todolist.controllers;

import com.mindhub.todolist.dtos.TaskRequest;
import com.mindhub.todolist.dtos.TaskResponse;
import com.mindhub.todolist.interfaces.TaskService;
import com.mindhub.todolist.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/createTask")
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest request) throws Exception{
        try {
            TaskResponse response = taskService.createTask(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getTask/{id}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable("id") Long id) throws Exception{
        try {
            TaskResponse response = taskService.getTask(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/updateTask/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable("id") Long id, @RequestBody TaskRequest request) throws Exception{
        try {
            TaskResponse response = taskService.updateTask(id, request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) throws Exception{
        try {
            String response = taskService.DeleteTask(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getAllTask")
    public ResponseEntity<List<Task>> getAllTasks() throws Exception{
        try {
            return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }
    }


}
