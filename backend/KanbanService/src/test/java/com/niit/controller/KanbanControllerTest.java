//package com.niit.controller;
//
//
//import com.niit.exception.KanbanNotFoundException;
//import com.niit.model.Kanban;
//import com.niit.model.Subtask;
//import com.niit.model.Task;
//import com.niit.model.TaskStatus;
//import com.niit.service.KanbanService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.LocalDateTime;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class KanbanControllerTest {
//
//  @Autowired
//  private MockMvc mockMvc;
//
//  @Mock
//  private KanbanService kanbanService;
//
//  @InjectMocks
//  private KanbanController kanbanController;
//
//  Kanban kanban;
//  List<Task> tasks = new ArrayList<>();
//  Task task;
//  Subtask subtask;
//  TaskStatus taskStatus;
//
//  @BeforeEach
//  public void setUp() {
//    task = new Task(101, "Project", "Capstone Project", "Red", "Shivam", LocalDateTime.of(2019, Month.MARCH, 28, 14, 33), LocalDateTime.of(2020, Month.MARCH, 28, 14, 33), taskStatus, subtask);
//    subtask = new Subtask("services", "creation of services");
//    taskStatus = new TaskStatus(true, false, false);
//    tasks.add(task);
//    kanban = new Kanban(101, "kanban test", tasks);
//  }
//
//  @AfterEach
//  public void tearDown() {
//    task = null;
//    subtask = null;
//    taskStatus = null;
//    tasks = null;
//    kanban = null;
//  }
//}
//
//
