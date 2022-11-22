package com.niit.service;

import com.niit.exception.TaskNotFoundException;
import com.niit.model.Task;
import com.niit.model.TaskDTO;
import com.niit.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasksList = new ArrayList<>();
        taskRepository.findAll().forEach(tasksList::add);
        return tasksList;
    }

    @Override
    public Optional<Task> getTaskByTaskId(int taskId) {
        return taskRepository.findById(taskId);
    }

    @Override
    public Optional<Task> getTaskByTaskName(String taskName) {
        return taskRepository.findByTaskName(taskName);
    }

    @Override
    public Task saveNewTask(TaskDTO taskDTO) {
        return taskRepository.save(convertDTOToTask(taskDTO));
    }

    @Override
    public Task updateTask(Task oldTask, TaskDTO newTaskDTO) {
        return taskRepository.save(updateTaskFromDTO(oldTask, newTaskDTO));
    }

    @Override
    public void deleteTask(Task task){
        taskRepository.delete(task);
    }


    private Task convertDTOToTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTaskId(taskDTO.getTaskId());
        task.setTaskName(taskDTO.getTaskName());
        task.setTaskDescription(taskDTO.getTaskDescription());
        task.setUserName(taskDTO.getUserName());
        task.setTaskStatus(taskDTO.getTaskStatus());
        return task;
    }

    private Task updateTaskFromDTO(Task task, TaskDTO taskDTO){
        if(Optional.ofNullable(taskDTO.getTaskName()).isPresent()){
            task.setTaskName(taskDTO.getTaskName());
        }

        if (Optional.ofNullable((taskDTO.getTaskDescription())).isPresent()) {
            task.setTaskDescription(taskDTO.getTaskDescription());
        }

        if (Optional.ofNullable((taskDTO.getUserName())).isPresent()) {
            task.setUserName(taskDTO.getUserName());
        }

        if (Optional.ofNullable((taskDTO.getTaskStatus())).isPresent()) {
            task.setTaskStatus(taskDTO.getTaskStatus());
        }
        return task;
    }
}
