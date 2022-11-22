package com.niit.rabbitmq.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.niit.model.Subtask;
import com.niit.model.TaskStatus;

import java.time.LocalDateTime;

public class TaskDTO {
    private int taskId;
    private String taskName;
    private String taskDescription;
    private String taskColor;
    private String userName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime taskStartDateAndTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime taskEndDateAndTime;

//    private TaskStatusDTO taskStatusDTO;
    private SubtaskDTO subtaskDTO;

    public TaskDTO() {
    }

    public TaskDTO(int taskId, String taskName, String taskDescription, String taskColor, String userName, LocalDateTime taskStartDateAndTime, LocalDateTime taskEndDateAndTime,  SubtaskDTO subtaskDTO) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskColor = taskColor;
        this.userName = userName;
        this.taskStartDateAndTime = taskStartDateAndTime;
        this.taskEndDateAndTime = taskEndDateAndTime;
//        this.taskStatusDTO = taskStatusDTO;
        this.subtaskDTO = subtaskDTO;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskColor() {
        return taskColor;
    }

    public void setTaskColor(String taskColor) {
        this.taskColor = taskColor;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getTaskStartDateAndTime() {
        return taskStartDateAndTime;
    }

    public void setTaskStartDateAndTime(LocalDateTime taskStartDateAndTime) {
        this.taskStartDateAndTime = taskStartDateAndTime;
    }


    public LocalDateTime getTaskEndDateAndTime() {
        return taskEndDateAndTime;
    }

    public void setTaskEndDateAndTime(LocalDateTime taskEndDateAndTime) {
        this.taskEndDateAndTime = taskEndDateAndTime;
    }


//    public TaskStatusDTO getTaskStatusDTO() {
//        return taskStatusDTO;
//    }

//    public void setTaskStatusDTO(TaskStatusDTO taskStatusDTO) {
//        this.taskStatusDTO = taskStatusDTO;
//    }

    public SubtaskDTO getSubtaskDTO() {
        return subtaskDTO;
    }

    public void setSubtaskDTO(SubtaskDTO subtaskDTO) {
        this.subtaskDTO = subtaskDTO;
    }
}
