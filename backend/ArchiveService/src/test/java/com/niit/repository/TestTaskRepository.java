//package com.niit.repository;
//
//import com.niit.model.Image;
//import com.niit.model.Task;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.time.LocalDateTime;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@DataMongoTest
//@ExtendWith(SpringExtension.class)
//public class TestTaskRepository {
//
//    @Autowired
//    private TaskRepository taskRepository;
//
//    private Image image,image2;
//
//    private Task task,task2;
//    List<Task> taskList = new ArrayList<>();
//    List<Image> imageList = new ArrayList<>();
//
//    @BeforeEach
//    public void setUp(){
//
//        image= new Image("1","task.img");
//        image2=new Image("2","task2.img");
//        imageList.add(image);
//        imageList.add(image2);
//       task =new Task(101,"Project","capstone project","blue",202,"Pravin", LocalDateTime.of(2019, Month.MARCH, 28, 14, 33),LocalDateTime.of(2019, Month.MARCH, 28, 14, 33),List.of(image,image2));
//        task2 =new Task(102,"Project","capstone project","blue",203,"Pravin", LocalDateTime.of(2019, Month.MARCH, 28, 14, 33),LocalDateTime.of(2019, Month.MARCH, 28, 14, 33),List.of(image,image2));
//        taskList.add(task);
//        taskList.add(task2);
//        taskRepository.save(task);
//
//
//    }
//
//    @AfterEach
//    public void tearDown(){
//
//        image=null;
//        image2=null;
//        imageList=null;
//        task=null;
//        task2=null;
//        taskList=null;
//        taskRepository.deleteAll();
//
//    }
//
//    @Test
//    public void saveArchiveTaskTrue(){
//
//        taskRepository.save(task);
//        assertEquals(task.getTaskId(),taskRepository.findById(task.getTaskId()).get().getTaskId());
//
//    }
//
//    @Test
//    public void saveArchiveTaskFalse(){
//
//        taskRepository.save(task);
//        assertNotEquals(task2.getTaskId(),taskRepository.findById(task.getTaskId()).get().getTaskId());
//
//    }
//
////    @Test
////    public void getAllArchiveTaskOfUserTrue(){
////
////        assertEquals(task.getTaskId(),taskRepository.findTaskByUserId(202).size());
////    }
//
//    @Test
//    public void getAllArchiveTaskOfUserFalse(){
//
//        assertNotEquals(task.getTaskId(),taskRepository.findTaskByUserId(12).size());
//        assertNotEquals(task2.getTaskId(),taskRepository.findTaskByUserId(11).size());
//    }
//    @Test
//    public void testDeleteTaskFromArchive(){
//        taskRepository.save(task);
//        taskRepository.delete(task);
//        assertEquals(0,taskRepository.findTaskByUserId(task.getUserId()).size());
//
//    }
//    @Test
//    public void testDeleteTaskFromArchiveFalse(){
//
//        taskRepository.save(task);
//        taskRepository.delete(task);
//        assertNotEquals(task,taskRepository.findTaskByUserId(task.getUserId()).size());
//
//    }
//
//
//}
