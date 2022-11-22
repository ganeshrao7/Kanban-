package com.niit.controller;


import com.niit.exception.TaskNotFoundException;
import com.niit.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/archive-service/api/v1")
public class TaskController {

    @Autowired
    private TaskService taskService;
    private ResponseEntity responseEntity;


    @GetMapping("/tasks/{userId}")
    public ResponseEntity<?> getAllTasksOfUser(@PathVariable("userId") int userId) {
        try {
            return new ResponseEntity<>(taskService.getAllTasksOfUser(userId), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/task/{taskID}")
    public ResponseEntity<?> deleteTaskFromArchive(@PathVariable("taskID") int taskID) throws TaskNotFoundException {
        try {
            return new ResponseEntity<>(taskService.deleteTaskFromArchive(taskID), HttpStatus.NOT_FOUND);
        } catch(TaskNotFoundException e) {
            throw new TaskNotFoundException();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
