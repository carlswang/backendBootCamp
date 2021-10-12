package com.example.backendbootcamp.service;

import com.example.backendbootcamp.entity.Task;
import com.example.backendbootcamp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public int saveTask(Task task) {
        return taskRepository.saveTask(task);
    }

    public List<Task> findAllTask() {
        return taskRepository.findAllTask();
    }

    public Task findTaskById(int id)  {
        return taskRepository.findTaskById(id);
    }

    public List<Task> deleteTaskById(int id) {
        return taskRepository.deleteTaskById(id);
    }

    public List<Task> updateTask(Task task) {
        return taskRepository.updateTask(task);
    }
}