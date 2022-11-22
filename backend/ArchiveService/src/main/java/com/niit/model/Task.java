package com.niit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class Task {

    @Id
    private int taskId;
    private String taskName;
    private String taskDescription;
    private String taskColor;
    private int userId;
    private String userName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime taskStartDateAndTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime taskEndDateAndTime;
    private List<Image> images;


    public Task() {
    }

    public Task(int taskId, String taskName, String taskDescription, String taskColor,int userId, String userName, LocalDateTime taskStartDateAndTime, LocalDateTime taskEndDateAndTime, List<Image> images) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskColor = taskColor;
        this.userId=userId;
        this.userName = userName;
        this.taskStartDateAndTime = taskStartDateAndTime;
        this.taskEndDateAndTime = taskEndDateAndTime;
        this.images = images;
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskColor='" + taskColor + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", taskStartDateAndTime=" + taskStartDateAndTime +
                ", taskEndDateAndTime=" + taskEndDateAndTime +
                ", images=" + images +
                '}';
    }
}
