package com.example.backendbootcamp.repository;

import com.example.backendbootcamp.entity.Task;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;
    private Task testTask;

    @BeforeEach
    void setUp() {
        testTask = Task.builder()
                .id(123)
                .name("study")
                .describe("Study is very important to everyone")
                .build();
    }

    @AfterEach
    void resetTask() {
        taskRepository.deleteTaskById(123);
    }

    @Test
    void should_get_one_task_when_task_has_been_saved() {
        taskRepository.saveTask(testTask);
        Task taskById = taskRepository.findTaskById(123);
        Assertions.assertEquals(123, taskById.getId());
        Assertions.assertEquals(testTask.getName(), taskById.getName());
    }

    @Test
    void should_get_updated_task_when_task_list_has_been_updated() {
        Task updateTask = Task.builder()
                .id(123)
                .name("play games")
                .describe("play games is good for your life")
                .build();
        taskRepository.saveTask(testTask);
        taskRepository.updateTask(updateTask);
        Task taskById = taskRepository.findTaskById(123);
        Assertions.assertEquals(123, taskById.getId());
        Assertions.assertEquals(updateTask.getName(), taskById.getName());
    }
}