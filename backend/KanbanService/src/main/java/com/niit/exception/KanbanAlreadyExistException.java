package com.niit.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason = "Kanban already exists")

public class KanbanAlreadyExistException extends Exception{

}
