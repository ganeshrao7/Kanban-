//package com.niit.service;
//import com.niit.exception.TaskNotFoundException;
//import com.niit.model.Image;
//
//import com.niit.model.Task;
//
//import com.niit.repository.TaskRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import java.time.LocalDateTime;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class TaskServiceTest {
//
//    private Task task,task2;
//    private Image image,image2;
//    List<Task> taskList = new ArrayList<>();
//    List<Image> imageList = new ArrayList<>();
//
//
//
//    @InjectMocks
//    private TaskServiceImpl service;
//
//    @Mock
//    private TaskRepository repository;
//
//
//    @BeforeEach
//    public void setUp()
//    {
//        image= new Image("1","task.img");
//        image2=new Image("2","task2.img");
//        imageList.add(image);
//        imageList.add(image2);
//        task =new Task(101,"Project","capstone project","blue",202,"Pravin",LocalDateTime.of(2019, Month.MARCH, 28, 14, 33),LocalDateTime.of(2019,Month.MARCH, 28, 14, 33),List.of(image, image2));
//        task2 =new Task(102,"Project","capstone project","blue",203,"Pravin", LocalDateTime.of(2019, Month.MARCH, 28, 14, 33),LocalDateTime.of(2019, Month.MARCH, 28, 14, 33),List.of(image,image2));
//        taskList.add(task);
//        taskList.add(task2);
//    }
//
//    @AfterEach
//    public void tearDown()
//    {
//        image=null;
//        image2=null;
//        imageList=null;
//        task=null;
//        task2=null;
//        taskList=null;
//
//    }
//
////    @Test
////    public void saveTaskTest()
////    {
////        when(repository.save(task)).thenReturn(task);
////        assertEquals(task,service.saveTask(task));
////    }
//
////    @Test
////    public void deleteTaskTest()throws TaskNotFoundException
////    {
////        repository.save(task);
////        repository.deleteById(task.getTaskId());
////        Optional optional = repository.findById(task.getTaskId());
////        assertEquals(Optional.empty(), optional);
////    }
//
////    @Test
////    public void getAllTaskTestById(int userId) {
////      repository.save(task2);
////      List<Task> task=repository.findTaskByUserId(task2.getUserId());
////      assertEquals(task2.getUserId(),203);
////    }
////@Test
////public void testGetAllArchiveTaskOfUserTrue() throws Exception{
////
////    when(repository.findById(anyInt())).thenReturn(Optional.of(task));
////    assertEquals(2,service.getAllTasksOfUser(anyInt()).size());
////    verify(repository,times(1)).findById(anyInt());
////
////}
//
//    @Test
//    public void getByIdTest()
//    {
//        repository.save(task);
//        Optional optional = repository.findById(task.getTaskId());
//        assertEquals(task.getTaskId(), 101);
//    }
//
//}