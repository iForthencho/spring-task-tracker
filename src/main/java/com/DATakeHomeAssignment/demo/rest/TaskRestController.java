package com.DATakeHomeAssignment.demo.rest;

import com.DATakeHomeAssignment.demo.entity.Task;
import com.DATakeHomeAssignment.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskRestController {

    private TaskService taskService;

    @Autowired
    public TaskRestController(TaskService theTaskService) {

        taskService = theTaskService;
    }

    // expose "/task" and return a list of tasks
    @GetMapping("/tasks")
    public List<Task> findAll() {

        return taskService.findAll();
    }

    // add mapping for GET /tasks/{taskId}
    @GetMapping("/tasks/{taskId}")
    public Task getTask(@PathVariable long taskId) {

        Task theTask = taskService.findById(taskId);

        if (theTask == null) {
            throw new RuntimeException("Task id not found - " + taskId);
        }

        return theTask;
    }

    // add mapping for POST /tasks - add new task
    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task theTask) {

        // just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theTask.setId(0);

        // get the newly created task object from db
        Task dbTask = taskService.save(theTask);

        return dbTask;
    }

    // add mapping for PUT /tasks - update existing task
    @PutMapping("/tasks")
    public Task updateTask(@RequestBody Task theTask) {

        Task dbTask = taskService.save(theTask);

        return dbTask;
    }

    // add mapping for DELETE /tasks/{taskId} - delete task
    @DeleteMapping("/tasks/{taskId}")
    public  String deleteTask(@PathVariable long taskId) {

        Task tempTask = taskService.findById(taskId);

        // throw exception if null
        if (tempTask == null) {
            throw new RuntimeException("Task id not found - " + taskId);
        }

        taskService.deleteById(taskId);

        return "Deleted task id - " + taskId;
    }
}
