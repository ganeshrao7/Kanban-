package com.niit.rabbitmq.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
//import com.niit.model.Subtask;
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

    private TaskStatus taskStatus;
//    private Subtask subtask;

    public TaskDTO() {
    }

    public TaskDTO(int taskId, String taskName, String taskDescription, String taskColor, String userName, LocalDateTime taskStartDateAndTime, LocalDateTime taskEndDateAndTime, TaskStatus taskStatus) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskColor = taskColor;
        this.userName = userName;
        this.taskStartDateAndTime = taskStartDateAndTime;
        this.taskEndDateAndTime = taskEndDateAndTime;

        this.taskStatus = taskStatus;
//        this.subtask = subtask;
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

//    public LocalDateTime getTaskStartTimeAndTime() {
//        return getTaskStartTimeAndTime();
//    }

//    public void setTaskStartTime(LocalDateTime taskStartTime) {
//        this.taskStartTime = taskStartTime;
//    }

    public LocalDateTime getTaskEndDateAndTime() {
        return taskEndDateAndTime;
    }

    public void setTaskEndDateAndTime(LocalDateTime taskEndDateAndTime) {
        this.taskEndDateAndTime = taskEndDateAndTime;
    }

//    public LocalDateTime getTaskEndTime() {
//        return taskEndTime;
//    }
//
//    public void setTaskEndTime(LocalDateTime taskEndTime) {
//        this.taskEndTime = taskEndTime;
//    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

//    public Subtask getSubtask() {
//        return subtask;
//    }
//
//    public void setSubtask(Subtask subtask) {
//        this.subtask = subtask;
//    }
}
