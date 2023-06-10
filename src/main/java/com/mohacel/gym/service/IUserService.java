package com.mohacel.gym.service;

import com.mohacel.gym.dto.UserDto;
import java.util.List;

public interface IUserService {
    public String createUser(UserDto user);
    public boolean deleteUser(Integer userId);
    public String updateUser(Integer userId,UserDto user);
    public UserDto getSingleUser(Integer userId);
    public List<UserDto> getAllUser();
}
