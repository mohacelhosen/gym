package com.mohacel.gym.service.impl;

import com.mohacel.gym.dto.UserDto;
import com.mohacel.gym.entity.UserEntity;
import com.mohacel.gym.repository.UserRepository;
import com.mohacel.gym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repository;
    @Override
    public String createUser(UserDto user) {
        UserEntity entity = new UserEntity();
        String password = generateRandomString(8);
        entity.setPassword(password);
        BeanUtils.copyProperties(user, entity);
        Integer userId = repository.save(entity).getId();

        if (userId !=null){
            return "8-Digit User Password::"+password;
        }else {
            return "false";
        }
    }

    @Override
    public boolean deleteUser(Integer userId) {
        Boolean flag = false;
        if(repository.findById(userId).isPresent()){
            repository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public String updateUser(Integer userId,UserDto user) {
        UserEntity entity = new UserEntity();
        if (repository.findById(userId).isPresent()){
        BeanUtils.copyProperties(user, entity);
        repository.save(entity);
        return "Successfully Updated";
        }
        return "Failed to Update";
    }

    @Override
    public UserDto getSingleUser(Integer userId) {
        Optional<UserEntity> userEntity = repository.findById(userId);
        UserDto user = new UserDto();
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserEntity> userEntities = repository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for(UserEntity user: userEntities){
            UserDto tempUser = new UserDto();
            BeanUtils.copyProperties(user, tempUser);
            userDtoList.add(tempUser);
        }
        return userDtoList;
    }

    // to generate random password
    private String generateRandomString(int length) {
        final String ALPHANUMERIC_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";

        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALPHANUMERIC_CHARS.length());
            char randomChar = ALPHANUMERIC_CHARS.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
