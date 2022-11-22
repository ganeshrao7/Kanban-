//package com.niit.controller;
//
//
//import com.niit.model.Image;
//import com.niit.model.Task;
//import com.niit.service.TaskService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.time.LocalDateTime;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class TaskControllerTest {
//
//
//    @Autowired
//    private MockMvc mockMvc;
//    @Mock
//    private TaskService taskService;
//    private Task task,task2;
//    private Image image,image2;
//    List<Task> taskList = new ArrayList<>();
//    List<Image> imageList = new ArrayList<>();
//
//    @InjectMocks
//    private TaskController taskController;
//    @BeforeEach
//    public void setUp(){
//    image= new Image("1","task.img");
//    image2=new Image("2","task2.img");
//        imageList.add(image);
//        imageList.add(image2);
//    task =new Task(101,"Project","capstone project","blue",202,"Pravin",LocalDateTime.of(2019, Month.MARCH, 28, 14, 33),LocalDateTime.of(2019,Month.MARCH, 28, 14, 33),List.of(image, image2));
//    task2 =new Task(102,"Project","capstone project","blue",203,"Pravin", LocalDateTime.of(2019, Month.MARCH, 28, 14, 33),LocalDateTime.of(2019, Month.MARCH, 28, 14, 33),List.of(image,image2));
//        taskList.add(task);
//        taskList.add(task2);
//        mockMvc= MockMvcBuilders.standaloneSetup(taskController).build();
//        }
//    @AfterEach
//    public void tearDown(){
//
//        image=null;
//        image2=null;
//        imageList=null;
//        task=null;
//        task2=null;
//        taskList=null;
//        mockMvc=null;
//    }
//    @Test
//    public void deleteTaskDetailById() throws Exception{
//        mockMvc.perform( delete("/api/v1/taskservice/task/103", 103) )
//                .andExpect(status().isNotFound());
//
//    }
//    @Test
//    public void deleteTaskDetailByIdIsFound() throws Exception{
//        mockMvc.perform( delete("/api/v1/taskservice/task/102", 102) )
//                .andExpect(status().isNotFound());
//
//    }
////    @Test
////    public void getById() throws Exception{
////        when(taskService.getAllTasksOfUser(203)).thenReturn((List<Task>) task2);
////        mockMvc.perform(get("/api/v1/taskservice/tasks/203")
////                        .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
////                .andDo(MockMvcResultHandlers.print());
////    }
//
//    @Test
//    public void getAllProduct() throws Exception
//    {
//        mockMvc.perform(get("/api/v1/taskservice/tasks/203")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//}
