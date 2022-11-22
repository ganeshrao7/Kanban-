package com.niit.config;
import com.fasterxml.jackson.annotation.JsonFormat;
//import com.niit.model.Subtask;
import com.niit.model.Task;
import com.niit.model.TaskStatus;
import com.niit.rabbitmq.domain.TaskDTO;
import com.niit.service.TaskServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Consumer {
    @Autowired
    private TaskServiceImpl taskService;

    @RabbitListener(queues = "task_queue")
    public void getTaskDtoFromRabbitMq(TaskDTO taskDTO) {
        Task task =new Task();
        task.setTaskId(taskDTO.getTaskId());
        task.setTaskName(taskDTO.getTaskName());
        task.setTaskDescription(taskDTO.getTaskDescription());
//        task.setTaskColor(taskDTO.getTaskColor());
//        task.setUserName(taskDTO.getUserName());
//        task.setTaskStartDateAndTime(taskDTO.getTaskStartDateAndTime());
//        task.setTaskEndDateAndTime(taskDTO.getTaskEndDateAndTime());
//        task.setTaskStatus(taskDTO.getTaskStatusDTO());
//        task.setSubtask(taskDTO.getSubtaskDTO());
////        taskService.saveNewTask(task);
    }
}

