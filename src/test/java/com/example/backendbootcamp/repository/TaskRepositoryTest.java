package com.example.backendbootcamp.repository;

import com.example.backendbootcamp.entity.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void should_get_one_task_when_task_has_been_saved() {
        Task testTask = Task.builder()
                .id(123)
                .name("study")
                .describe("Study is very important to everyone")
                .build();
        taskRepository.saveTask(testTask);
        Task taskById = taskRepository.findTaskById(123);
        Assertions.assertEquals(123, taskById.getId());
        Assertions.assertEquals(testTask.getName(), taskById.getName());
    }
}