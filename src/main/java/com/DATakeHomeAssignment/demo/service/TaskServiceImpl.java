package com.DATakeHomeAssignment.demo.service;


import com.DATakeHomeAssignment.demo.dao.TaskRepository;
import com.DATakeHomeAssignment.demo.entity.Task;
import com.DATakeHomeAssignment.demo.exception.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository theTaskRepository) {
        taskRepository = theTaskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(long theId) throws TaskNotFoundException {
        Optional<Task> result = taskRepository.findById(theId);

        Task theTask = null;

        if (result.isPresent()) {
            theTask = result.get();
        }
        else {
            // task was not found
            throw new TaskNotFoundException("Task id not found - " + theId);
        }

        return theTask;
    }

    @Override
    public Task save(Task theTask) {
        return taskRepository.save(theTask);
    }

    @Override
    public void deleteById(long theId) {
        taskRepository.deleteById(theId);
    }

    @Override
    public Task updateTask(Long id, Task theTask) {

        Task task = new Task();
        task.setId(id);
        task.setTitle(theTask.getTitle());
        task.setDescription(theTask.getDescription());
        task.setCompleted(theTask.getCompleted());

        return taskRepository.save(task);
    }
}
