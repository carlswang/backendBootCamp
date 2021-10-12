package com.example.backendbootcamp.controller;

import com.example.backendbootcamp.entity.Task;
import com.example.backendbootcamp.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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

    @Test
    void should_return_task_when_find_task_by_id_called() throws Exception {
        int id = 123;
        Mockito.when(taskService.findTaskById(id)).thenReturn(testTask);

        mockMvc.perform(MockMvcRequestBuilders.get("/tasks/{id}",123))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

        Mockito.verify(taskService).findTaskById(123);
    }
}
