package com.niit.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class Kanban {

    @Id
    private int kanbanId;
    private String KanbanTitle;
    private String email;
    private List<Task> tasks;


    public Kanban() {

    }

    public Kanban(int kanbanId, String kanbanTitle, String email, List<Task> tasks) {
        this.kanbanId = kanbanId;
        KanbanTitle = kanbanTitle;
        this.email = email;
        this.tasks = tasks;
    }

    public int getKanbanId() {
        return kanbanId;
    }

    public void setKanbanId(int kanbanId) {
        this.kanbanId = kanbanId;
    }

    public String getKanbanTitle() {
        return KanbanTitle;
    }

    public void setKanbanTitle(String kanbanTitle) {
        KanbanTitle = kanbanTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {

        if (Objects.isNull(tasks)) {
            tasks = new ArrayList<>();
        }
        tasks.add(task);
    }
}