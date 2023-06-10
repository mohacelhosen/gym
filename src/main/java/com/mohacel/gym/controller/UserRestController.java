package com.mohacel.gym.controller;

import com.mohacel.gym.dto.UserDto;
import com.mohacel.gym.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    private UserServiceImpl service;

    //save the user info
    @PostMapping("/user")
    public ResponseEntity<String> userRegistration(@RequestBody UserDto user)  {

        String isSaved = service.createUser(user);


        if (isSaved.equalsIgnoreCase("false")){
            return new ResponseEntity<>("Registration Fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return  new ResponseEntity<>(isSaved, HttpStatus.CREATED);
        }
    }

    // get single user by userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
        UserDto user = service.getSingleUser(userId);
        return  new ResponseEntity<>(user, HttpStatus.OK);
    }

    // delete the user by userId
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Integer userId){
        boolean isDeleted = service.deleteUser(userId);
        if (isDeleted){
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }else {
            return  new ResponseEntity<>("Failed to Delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // retrieve all the user
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> allUser = service.getAllUser();
        return  new ResponseEntity<>(allUser,HttpStatus.OK);
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<String> updateUserInfo(@PathVariable Integer userId,@RequestBody UserDto user){
        String updateUserInfo = service.updateUser(userId, user);
        return  new ResponseEntity<>(updateUserInfo, HttpStatus.OK);
    }
}
