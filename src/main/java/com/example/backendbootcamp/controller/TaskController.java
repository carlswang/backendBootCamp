package com.example.backendbootcamp.controller;

import com.example.backendbootcamp.entity.Task;
import com.example.backendbootcamp.service.TaskService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(path = "/tasks", method = RequestMethod.POST)
    public int saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @RequestMapping(path = "/allTasks", method = RequestMethod.GET)
    public List<Task> findAllTask() {
        return taskService.findAllTask();
    }

    @RequestMapping(path = "/tasks/{id}", method = RequestMethod.DELETE)
    public List<Task> deleteTaskById(@PathVariable(name = "id") int id) {
        return taskService.deleteTaskById(id);
    }

    @RequestMapping(path = "/tasks/update", method = RequestMethod.POST)
    public List<Task> updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @RequestMapping(path = "/tasks/{id}", method = RequestMethod.GET)
    public List<Task> findTaskById(@PathVariable(name = "id") int id) {
        return taskService.findTaskById(id);
    }
}