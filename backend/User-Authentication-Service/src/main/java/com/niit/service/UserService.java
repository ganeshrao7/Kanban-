package com.niit.service;

import com.niit.exception.UserAlreadyExistsException;
import com.niit.exception.UserNotFoundException;
import com.niit.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user)throws UserAlreadyExistsException;
    public User findByEmailAndPassword(String userName,String password) throws UserNotFoundException;
    public List<User> getAllUsers();
}
