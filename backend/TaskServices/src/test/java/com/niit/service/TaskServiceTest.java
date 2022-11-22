//package com.niit.service;
//import com.niit.exception.TaskNotFoundException;
//import com.niit.model.Subtask;
//import com.niit.model.Task;
//import com.niit.model.TaskStatus;
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
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class TaskServiceTest {
//
//    Task task ;
//    Subtask subtask;
//    TaskStatus taskStatus;
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
//        task=new Task(101,"Project","Capstone Project","Red","Shivam", LocalDateTime.of(2019, Month.MARCH, 28, 14, 33),LocalDateTime.of(2020, Month.MARCH, 28, 14, 33),taskStatus,subtask);
//        subtask=new Subtask("services","creation of services");
//        taskStatus=new TaskStatus(true,false,false);
//    }
//
//    @AfterEach
//    public void tearDown()
//    {
//        task=null;
//        subtask=null;
//        taskStatus=null;
//    }
//
//    @Test
//    public void saveTaskTest()
//    {
//        when(repository.save(task)).thenReturn(task);
//        assertEquals(task,service.saveTask(task));
//    }
//
//    @Test
//    public void deleteTaskTest()throws TaskNotFoundException
//    {
//        repository.save(task);
//        repository.deleteById(task.getTaskId());
//        Optional optional = repository.findById(task.getTaskId());
//        assertEquals(Optional.empty(), optional);
//    }
//
//    @Test
//    public void getAllTaskTest() {
//        when(repository.findAll()).thenReturn(Stream.of(task).collect(Collectors.toList()));
//        assertEquals(1, service.getAllTasks().size());
//    }
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
