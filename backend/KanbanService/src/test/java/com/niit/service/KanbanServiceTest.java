//package com.niit.service;
//import com.niit.exception.KanbanAlreadyExistException;
//import com.niit.exception.KanbanNotFoundException;
//import com.niit.model.Kanban;
//import com.niit.model.Subtask;
//import com.niit.model.Task;
//import com.niit.model.TaskStatus;
//import com.niit.repository.KanbanRepository;
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
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class KanbanServiceTest {
//
//  Kanban kanban;
//  List<Task> tasks=new ArrayList<>();
//  Task task;
//  Subtask subtask;
//  TaskStatus taskStatus;
//
//  @InjectMocks
//  private KanbanServiceImpl service;
//
//  @Mock
//  private KanbanRepository repository;
//
//  @BeforeEach
//  public void setUp()
//  {
//    task=new Task(101,"Project","Capstone Project","Red","Shivam", LocalDateTime.of(2019, Month.MARCH, 28, 14, 33),LocalDateTime.of(2020, Month.MARCH, 28, 14, 33),taskStatus,subtask);
//    subtask=new Subtask("services","creation of services");
//    taskStatus=new TaskStatus(true,false,false);
//    tasks.add(task);
//    kanban=new Kanban(102,"kanban test",tasks);
//  }
//
//  @AfterEach
//  public void tearDown()
//  {
//    task=null;
//    subtask=null;
//    taskStatus=null;
//    tasks=null;
//    kanban=null;
//  }
//
//  @Test
//  public void saveKanbanTest()throws KanbanAlreadyExistException
//  {
//    when(repository.save(kanban)).thenReturn(kanban);
//    assertEquals(kanban,service.saveKanban(kanban));
//  }
//
//  @Test
//  public void deleteKanbanTest()throws KanbanNotFoundException
//  {
//    repository.save(kanban);
//    repository.deleteById(kanban.getKanbanId());
//    Optional optional = repository.findById(kanban.getKanbanId());
//    assertEquals(Optional.empty(), optional);
//  }
//
//
//}
