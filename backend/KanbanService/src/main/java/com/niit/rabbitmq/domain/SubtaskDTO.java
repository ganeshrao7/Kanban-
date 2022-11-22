package com.niit.rabbitmq.domain;

import com.niit.model.Subtask;

public class SubtaskDTO extends Subtask {
    private String subtaskName;
    private String subtaskDescription;

    public SubtaskDTO() {
    }

    public SubtaskDTO(String subtaskName, String subtaskDescription) {
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

}
