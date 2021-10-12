package com.example.backendbootcamp.controller;

import com.example.backendbootcamp.entity.Task;
import com.example.backendbootcamp.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    private Task testTask;

    @MockBean
    private TaskService taskService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        testTask = Task.builder()
                .id(123)
                .name("study")
                .describe("Study is very important to everyone")
                .build();
    }
}
