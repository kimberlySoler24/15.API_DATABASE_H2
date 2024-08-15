package com.mindhub.todolist.repositories;

import com.mindhub.todolist.dtos.TaskRequest;
import com.mindhub.todolist.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task,Long> {
}
