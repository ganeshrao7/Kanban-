package com.niit.service;

import com.niit.exception.TaskNotFoundException;
import com.niit.model.Task;
import com.niit.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;
    @Override
    public List<Task> getAllTasksOfUser(int userId) {
    return taskRepository.findTaskByUserId(userId);
    }

    @Override
    public boolean deleteTaskFromArchive(int taskID) throws TaskNotFoundException {
        Optional<Task> toBeDeleted = taskRepository.findById(taskID);

        if (toBeDeleted.isEmpty()) {
            throw new TaskNotFoundException();
        }

        taskRepository.delete(toBeDeleted.get());
        return true;
    }
    }

