package com.example.backendbootcamp.service;

import com.example.backendbootcamp.entity.Task;
import com.example.backendbootcamp.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void test_task_service_when_find_task_by_id() {
        int id = 123;
        Mockito.when(taskRepository.findTaskById(id))
                .thenReturn(Task.builder().id(id).name("study").describe("Study is very important to everyone").build());
        Task task = taskService.findTaskById(id);
        Assertions.assertEquals(id, task.getId());
    }
}