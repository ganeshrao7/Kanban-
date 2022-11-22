package com.niit.repository;

import com.niit.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository  extends MongoRepository<Task,Integer> {
    List<Task> findTaskByUserId(int userId);
}
