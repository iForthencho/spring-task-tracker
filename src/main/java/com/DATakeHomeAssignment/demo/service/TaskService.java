package com.DATakeHomeAssignment.demo.service;

import com.DATakeHomeAssignment.demo.entity.Task;
import com.DATakeHomeAssignment.demo.exception.TaskNotFoundException;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    Task findById(long theId) throws TaskNotFoundException;

    Task save(Task theTask);

    void deleteById(long theId);

    Task updateTask(Long id, Task theTask);

}
