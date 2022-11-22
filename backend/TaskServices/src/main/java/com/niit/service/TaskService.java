package com.niit.service;

import com.niit.exception.TaskNotFoundException;
import com.niit.model.Task;
import com.niit.model.TaskDTO;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    public List<Task> getAllTasks();

    public Optional<Task> getTaskByTaskId(int taskId);

    public Optional<Task> getTaskByTaskName(String taskName);

    public Task saveNewTask(TaskDTO taskDTO);

    public Task updateTask(Task oldTask, TaskDTO newTaskDTO);

    public void deleteTask(Task task);

}
