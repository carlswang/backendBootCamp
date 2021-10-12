package com.example.backendbootcamp.service;

import com.example.backendbootcamp.entity.Task;
import com.example.backendbootcamp.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
    private Task testTask;

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        testTask = Task.builder()
                .id(123)
                .name("study")
                .describe("Study is very important to everyone")
                .build();
    }

    @Test
    public void should_return_id_when_find_task_by_id_called() {
        int id = 123;
        Mockito.when(taskRepository.findTaskById(id))
                .thenReturn(testTask);
        Task task = taskService.findTaskById(id);
        Assertions.assertEquals(id, task.getId());
    }

    @Test
    public void should_return_all_task_when_findAllTask_called() {
        Mockito.when(taskRepository.findAllTask())
                .thenReturn(Arrays.asList(testTask));
        int taskSize = taskService.findAllTask().size();
        Assertions.assertEquals(1,taskSize);
    }

    @Test
    public void should_return_updated_result_when_task_has_been_updated() {
        Task updateTaskVar = Task.builder()
                .id(123)
                .name("running")
                .describe("running is good for health")
                .build();
        Mockito.when(taskRepository.updateTask(updateTaskVar))
                .thenReturn(Arrays.asList(updateTaskVar));
        List<Task> tasks = taskService.updateTask(updateTaskVar);
        Assertions.assertEquals("running",tasks.get(0).getName());
    }
}