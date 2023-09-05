package com.DATakeHomeAssignment.demo.dao;

import com.DATakeHomeAssignment.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // No coding required atm

}
