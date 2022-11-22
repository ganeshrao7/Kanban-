package com.niit.service;

import com.niit.exception.TaskNotFoundException;
import com.niit.model.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getAllTasksOfUser(int userId);
    public boolean deleteTaskFromArchive(int taskID) throws TaskNotFoundException;
}
