package com.mindhub.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserToDoList extends JpaRepository<UserToDoList,Long> {
}
