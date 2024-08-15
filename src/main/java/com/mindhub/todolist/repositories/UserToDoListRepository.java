package com.mindhub.todolist.repositories;

import com.mindhub.todolist.models.UserList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserToDoListRepository extends JpaRepository<UserList,Long> {
}
