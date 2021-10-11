package com.example.backendbootcamp.service;

import com.example.backendbootcamp.repository.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final List<Task> taskList = new ArrayList<>();

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

    public List<Task> deleteTaskById(int id) {
        taskList.remove(findTaskById(id).get(0));
        return taskList;
    }

    public List<Task> updateTask(Task task) {
        taskList.forEach(
                tasks -> {
                    if (tasks.getId() == task.getId()) {
                        tasks.setName(task.getName());
                        tasks.setDescribe(task.getDescribe());
                    }
                }
        );
        return taskList;
    }
}
