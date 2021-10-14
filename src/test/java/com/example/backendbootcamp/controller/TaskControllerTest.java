package com.example.backendbootcamp.controller;

import com.example.backendbootcamp.entity.Task;
import com.example.backendbootcamp.service.TaskService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@AutoConfigureJsonTesters
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    private Task testTask;

    @MockBean
    private TaskService taskService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JacksonTester<Task> taskJson;

    @BeforeEach
    void setUp() {
        testTask = Task.builder()
                .id(123)
                .name("study")
                .describe("Study is very important to everyone")
                .build();
    }

    @AfterEach
    void cleanUp() {
        Mockito.reset(taskService);
    }

    @Test
    void should_return_task_when_find_task_by_id_called() throws Exception {
        int id = 123;
        Mockito.when(taskService.findTaskById(id)).thenReturn(testTask);

        mockMvc.perform(MockMvcRequestBuilders.get("/tasks/{id}", 123))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

        Mockito.verify(taskService).findTaskById(123);
    }

    @Test
    void should_get_the_saved_task_when_task_list_is_saved() throws Exception {
        Task saveTasks = Task.builder()
                .id(123)
                .name("play games")
                .describe("play games is good for your life")
                .build();

        Mockito.when(taskService.saveTask(saveTasks)).thenReturn(111);

        MockHttpServletRequestBuilder content = MockMvcRequestBuilders.post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(taskJson.write(saveTasks).getJson());

        MockHttpServletResponse response = mockMvc.perform(content)
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        verify(taskService).saveTask(saveTasks);
    }
}
