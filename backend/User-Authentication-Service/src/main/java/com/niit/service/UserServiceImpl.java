package com.niit.service;

import com.niit.exception.UserAlreadyExistsException;
import com.niit.exception.UserNotFoundException;
import com.niit.model.User;
import com.niit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        Optional<User> user2 = userRepository.findById(user.getUserId());
        if (user2.isEmpty()) {
            return userRepository.save(user);
        }
        throw new UserAlreadyExistsException();
    }


    @Override
    public User findByEmailAndPassword(String email, String password) throws UserNotFoundException {
        User user = userRepository.findByEmailAndPassword(email,password);
        if(user==null){
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
