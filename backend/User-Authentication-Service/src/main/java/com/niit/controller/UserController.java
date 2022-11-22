package com.niit.controller;

import com.niit.exception.UserAlreadyExistsException;
import com.niit.exception.UserNotFoundException;
import com.niit.model.User;
import com.niit.service.SecurityTokenGenerator;
import com.niit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.Map;


@RestController
@RequestMapping("/authentication/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;

    private ResponseEntity responseEntity;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws UserNotFoundException{
        Map<String,String> map = null;
        try {
            User user1 = userService.findByEmailAndPassword(user.getEmail(),user.getPassword());
            if (user1.getEmail().equals(user.getEmail())){
                map = securityTokenGenerator.generateToken(user);
            }
            responseEntity = new ResponseEntity(map,HttpStatus.OK);
        }
        catch (UserNotFoundException ex){
            throw new UserNotFoundException();
        }
        catch (Exception e){
            e.printStackTrace();
            responseEntity = new ResponseEntity("internal server error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user)throws UserAlreadyExistsException
    {
        try {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    } catch (UserAlreadyExistsException ex) {
        throw ex;
    } catch (Exception ex) {
        ex.printStackTrace();
        return new ResponseEntity<>("An error occured!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
}
