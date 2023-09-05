package com.DATakeHomeAssignment.demo.service;

import com.DATakeHomeAssignment.demo.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    Task findById(long theId);

    Task save(Task theTask);

    void deleteById(long theId);

}
