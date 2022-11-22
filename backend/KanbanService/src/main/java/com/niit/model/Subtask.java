package com.niit.model;

public class Subtask {


    private String subtaskName;
    private String subtaskDescription;

    public Subtask() {
    }

    public Subtask(String subtaskName, String subtaskDescription) {
        this.subtaskName = subtaskName;
        this.subtaskDescription = subtaskDescription;
    }

    public String getSubtaskName() {
        return subtaskName;
    }

    public void setSubtaskName(String subtaskName) {
        this.subtaskName = subtaskName;
    }

    public String getSubtaskDescription() {
        return subtaskDescription;
    }

    public void setSubtaskDescription(String subtaskDescription) {
        this.subtaskDescription = subtaskDescription;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "subtaskName='" + subtaskName + '\'' +
                ", subtaskDescription='" + subtaskDescription + '\'' +
                '}';
    }
}
