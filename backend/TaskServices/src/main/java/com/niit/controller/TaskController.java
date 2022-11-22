package com.niit.controller;

import com.niit.exception.TaskNotFoundException;
import com.niit.model.Task;
import com.niit.model.TaskDTO;
import com.niit.service.SequenceGeneratorService;
import com.niit.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/task-service/api/v1")

public class TaskController {

    @Autowired
    private TaskService taskService;
    private ResponseEntity responseEntity;

    @Autowired
    private SequenceGeneratorService service;

    @GetMapping("/tasks")
    public ResponseEntity<?> getAllTasks(){
        try {
            responseEntity=new ResponseEntity(taskService.getAllTasks(),HttpStatus.OK);
        }
        catch (Exception ex){
            responseEntity=new ResponseEntity("error while fetching task data",HttpStatus.OK);
        }
        return responseEntity;
    }

    @GetMapping("{taskId}/tasks")
    public ResponseEntity<?> getByTaskId(@PathVariable("taskId")int taskId){
        try {
            Optional<Task> optTask = taskService.getTaskByTaskId(taskId);
            if (optTask.isPresent()) {
                responseEntity=new ResponseEntity<>(
                        optTask.get(),
                        HttpStatus.OK);
            } else {
                responseEntity=new ResponseEntity("error while fetching task data",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("/tasks/{taskName}")
    public ResponseEntity<?> getById(@PathVariable("taskName")String taskName){
        try {
            Optional<Task> optTask = taskService.getTaskByTaskName(taskName);
            if (optTask.isPresent()) {
                responseEntity=new ResponseEntity<>(
                        optTask.get(),
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No task found with a title: " + taskName, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }


    @PostMapping("/add")
    public ResponseEntity<?> saveTask(@RequestBody TaskDTO taskDTO)  {
        try {
            taskDTO.setTaskId(service.getSequenceNumber(taskDTO.SEQUENCE_NAME));
            return new ResponseEntity<>(
                    taskService.saveNewTask(taskDTO),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @PostMapping("/{taskId}/update")
    public ResponseEntity<?> updateTask(@PathVariable("taskId")int taskId, TaskDTO taskDTO) {
        try {
            Optional<Task> optTask = taskService.getTaskByTaskId(taskId);
            if (optTask.isPresent()) {
                return new ResponseEntity<>(
                        taskService.updateTask(optTask.get(), taskDTO),
                        HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity("error while updating task data", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @DeleteMapping("{id}/delete-task")
    public ResponseEntity<?> deleteTask(@PathVariable("id") int taskId) throws TaskNotFoundException {
            try {
                Optional<Task> optTask = taskService.getTaskByTaskId(taskId);
                if (optTask.isPresent()) {
                    taskService.deleteTask(optTask.get());
                    responseEntity= new ResponseEntity<>(String.format("Task with id: %d was deleted", taskId), HttpStatus.OK);
                } else {
                   responseEntity=new ResponseEntity("error while updating task data", HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return responseEntity;
    }



}
