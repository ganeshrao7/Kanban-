package com.niit.model;

import org.springframework.data.annotation.Transient;

public class TaskDTO {
    @Transient
    public static final String SEQUENCE_NAME="user1_sequence";
    private int taskId;
    private String taskName;
    private String taskDescription;
    private String userName;
    private TaskStatus taskStatus;

    public TaskDTO()
    {

    }

    public TaskDTO(int taskId, String taskName, String taskDescription, String userName, TaskStatus taskStatus) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.userName = userName;
        this.taskStatus = taskStatus;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}
