package com.ItTest.mapper;

import com.ItTest.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public  User  getUserByID(String username,String password );
    public  User getUserByUsername(String username);
    public  void CreateNewAccount(String username,String password);
    void updateUserInfo(User user);
    void UpdateAvatar(String avatarUrl,Integer id);
    void UpdatePwd(String newPwd,String username);
}

