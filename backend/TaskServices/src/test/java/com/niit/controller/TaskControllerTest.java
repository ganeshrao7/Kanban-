//package com.niit.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.niit.model.Subtask;
//import com.niit.model.Task;
//import com.niit.model.TaskStatus;
//import com.niit.repository.TaskRepository;
//import com.niit.service.TaskService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.time.LocalDateTime;
//import java.time.Month;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class TaskControllerTest{
//
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private TaskService taskService;
//
//    Task task ;
//    Subtask subtask;
//    TaskStatus taskStatus;
//
//
//
//    @InjectMocks
//    private TaskController taskController;
//
//    @BeforeEach
//    public void setUp()
//    {
//        task=new Task(111,"Project","Capstone Project","Red","Shivam", LocalDateTime.of(2019, Month.MARCH, 28, 14, 33),LocalDateTime.of(2020, Month.MARCH, 28, 14, 33),taskStatus,subtask);
//        subtask=new Subtask("services","creation of services");
//        taskStatus=new TaskStatus(true,false,false);
//        mockMvc= MockMvcBuilders.standaloneSetup(taskController).build();
//    }
//
//    @AfterEach
//    public void tearDown()
//    {
//        task=null;
//        subtask=null;
//        taskStatus=null;
//        mockMvc=null;
//    }
//
//
//
//  /*  @Test
//    public void saveTask() throws Exception {
//        when(taskService.saveTask(any())).thenReturn(task);
//        mockMvc.perform(post("/api/v1/taskservice/add")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsontoString(task)))
//                .andExpect(status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//        verify(taskService,times(1)).saveTask(any());
//    }
//
//    private String jsontoString(final Object obj) {
//        String result;
//        try {
//            ObjectMapper objectMapper=new ObjectMapper();
//            String jsonContent = objectMapper.writeValueAsString(obj);
//            result = jsonContent;
//        }
//        catch (JsonProcessingException ex){
//            result="error while converting to string";
//        }
//        return result;
//    }*/
//
//    @Test
//    public void getById() throws Exception{
//        when(taskService.getById(101)).thenReturn(java.util.Optional.ofNullable(task));
//        mockMvc.perform(get("/api/v1/taskservice/tasks/101")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void deleteTask() throws Exception{
//        mockMvc.perform( delete("/api/v1/taskservice/delete-task/101", 101) )
//                .andExpect(status().isNotFound());
//
//    }
//
//    @Test
//    public void getAllTasks() throws Exception
//    {
//        mockMvc.perform(get("/api/v1/taskservice/tasks")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//
//}