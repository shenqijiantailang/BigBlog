package com.ItTest.service.impl;

import com.ItTest.mapper.UserMapper;
import com.ItTest.pojo.User;
import com.ItTest.service.UserService;
import com.ItTest.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override

    public User findByUsername(String username ,String Password) {
        return userMapper.getUserByID(username,Password);

    }
    @Override
    public User ChekUniqueUsername(String username){
        return userMapper.getUserByUsername(username);

    }
    @Override
    public void CreateAccount(String username, String Password) {
        userMapper.CreateNewAccount(username,Password);

    }
    @Override
    public void UpdateUserInfo(User user){
        userMapper.updateUserInfo(user);
    }

    @Override
    public void UpdateAvatar(String avatarUrl,Integer id) {

        userMapper.UpdateAvatar(avatarUrl,id);

    }

    @Override
    public void UpdatePwd(String newPwd, String username) {
        userMapper.UpdatePwd(newPwd,username);
    }


}
