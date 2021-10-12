package com.example.backendbootcamp.repository;

import com.example.backendbootcamp.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TaskRepository {
    private final List<Task> taskList = new ArrayList<>();

    public int saveTask(Task task) {
        taskList.add(task);
        return taskList.size();
    }

    public List<Task> findAllTask() {
        return taskList;
    }

    public Task findTaskById(int id)  {
        return taskList.stream().filter(task -> (task.getId() == id)).collect(Collectors.toList()).get(0);
    }

    public List<Task> deleteTaskById(int id) {
        taskList.remove(findTaskById(id));
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
