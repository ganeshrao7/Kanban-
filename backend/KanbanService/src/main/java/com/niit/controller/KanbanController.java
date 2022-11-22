package com.niit.controller;


import com.niit.exception.KanbanAlreadyExistException;
import com.niit.exception.KanbanNotFoundException;
import com.niit.exception.UserAlreadyExistsException;
import com.niit.model.*;
import com.niit.service.KanbanService;
import com.niit.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/kanban-service/api/v1")
public class KanbanController {

    @Autowired
    private KanbanService kanbanService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    private ResponseEntity responseEntity;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
        try {
            responseEntity = new ResponseEntity<>(kanbanService.registerUser(user), HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            throw new UserAlreadyExistsException();
        }
        return responseEntity;
    }

    @GetMapping("/get-all-kanban")
    public ResponseEntity<?> getAllKanbans() {
        try {
            responseEntity = new ResponseEntity<>(
                    kanbanService.getAllKanbanBoards(),
                    HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("/kanban/{kanbanId}")
    public ResponseEntity<?> getKanbanById(@PathVariable("kanbanId") int kanbanId) {
        try {

            responseEntity = new ResponseEntity(kanbanService.getKanbanById(kanbanId), HttpStatus.OK);

        } catch (Exception ex) {
            responseEntity = new ResponseEntity("error while fetching kanban data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/byTitle/{kanbanTitle}")
    public ResponseEntity<?> getKanbanByTitle(@PathVariable("kanbanTitle") String kanbanTitle) {
        try {

            responseEntity = new ResponseEntity(kanbanService.getKanbanByTitle(kanbanTitle), HttpStatus.OK);

        } catch (Exception ex) {
            responseEntity = new ResponseEntity("error while fetching task data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


    @PostMapping("/save")
    public ResponseEntity<?> saveKanban(@RequestBody Kanban kanban) throws KanbanAlreadyExistException {
        try {
            kanbanService.saveKanban(kanban);
            responseEntity = new ResponseEntity(kanban, HttpStatus.CREATED);
        } catch (KanbanAlreadyExistException e) {
            throw new KanbanAlreadyExistException();
        } catch (Exception ex) {
            responseEntity = new ResponseEntity("Error while adding kanban board", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


    @DeleteMapping("/delete-kanban/{kanbanId}")
    public ResponseEntity<?> deleteKanbanById(@PathVariable("kanbanId") int kanbanId) throws KanbanNotFoundException {
        try {
            Optional<Kanban> optKanban = kanbanService.getKanbanById(kanbanId);
            if (optKanban.isPresent()) {
                kanbanService.deleteKanban(optKanban.get());
                responseEntity = new ResponseEntity<>(
                        String.format("Kanban with id: %d was deleted", kanbanId),
                        HttpStatus.OK);
            } else {
                return noKanbanFoundResponse(kanbanId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @PutMapping("/update-kanban/{kanbanId}")
    public ResponseEntity<?> updatekanban(@PathVariable("kanbanId") int kanbanId, KanbanDTO kanbanDTO) {
        try {
            Optional<Kanban> optKanban = kanbanService.getKanbanById(kanbanId);
            if (optKanban.isPresent()) {
                responseEntity = new ResponseEntity<>(
                        kanbanService.updatekanban(optKanban.get(), kanbanDTO),
                        HttpStatus.OK);
            } else {
                return noKanbanFoundResponse(kanbanId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @PostMapping("{kanbanId}/add")
    public ResponseEntity<?> createTaskAssignedToKanban(@PathVariable int kanbanId, @RequestBody TaskDTO taskDTO){
        try {
            taskDTO.setTaskId(sequenceGeneratorService.getSequenceNumber(taskDTO.SEQUENCE_NAME));
            return new ResponseEntity<Task>(
                    (MultiValueMap<String, String>) kanbanService.addNewTaskToKanban(kanbanId,taskDTO),HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity("Error while creating kanban board data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @GetMapping("/{kanbanId}/tasks/")
    public ResponseEntity<?> getAllTasksInKanbanId(@PathVariable("kanbanId") int kanbanId) {
        try {

            Optional<Kanban> optKanban = kanbanService.getKanbanById(kanbanId);
            if (optKanban.isPresent()) {
                responseEntity = new ResponseEntity<>(
                        optKanban.get().getTasks(),
                        HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @PostMapping("/save-new-kanban")
    public ResponseEntity<?> createKanban(@RequestBody KanbanDTO kanbanDTO) {
        try {
            kanbanDTO.setKanbanId(sequenceGeneratorService.getSequenceNumber(kanbanDTO.SEQUENCE_NAME));
            responseEntity = new ResponseEntity<>(
                    kanbanService.saveNewKanban(kanbanDTO),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @PostMapping("{kanbanId}/update")
    public ResponseEntity<?> UpdateTaskAssignToKanban(@PathVariable int kanbanId, @RequestBody Task task){
        try {

            return new ResponseEntity<Kanban>(kanbanService.updateTaskInKanban(kanbanId,task),HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity("Error while Updating kanban board data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("update")
    public ResponseEntity<?> updateKanban(@RequestBody Kanban kanban){
        try {
            return new ResponseEntity<Kanban>(
                    kanbanService.updatekanban(kanban),
                    HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity("Error while updating kanban board data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/{email}/kanban/")
    public ResponseEntity<?> getAllKanbanByEmail(@PathVariable("email") String email) {
        try {
            responseEntity = new ResponseEntity(kanbanService.getAllKanbanByEmail(email), HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity("Error while fetching kanban board data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    private ResponseEntity<String> noKanbanFoundResponse(int kanbanId) {
        return new ResponseEntity<>("No kanban found with id: " + kanbanId, HttpStatus.NOT_FOUND);
    }
}



