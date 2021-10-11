package com.example.backendbootcamp.service;

import com.example.backendbootcamp.repository.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private List<Task> taskList;

    public int saveTask(Task task) {
        taskList.add(task);
        return taskList.size();
    }

    public List<Task> findAllTask() {
        return taskList;
    }

    public List<Task> findTaskById(int id)  {
        return taskList.stream().filter(task -> (task.getId() == id)).collect(Collectors.toList());
    }

}
