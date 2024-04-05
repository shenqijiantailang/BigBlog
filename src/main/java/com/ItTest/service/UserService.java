package com.ItTest.service;

import com.ItTest.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
     User findByUsername(String username,String Password);
     User ChekUniqueUsername(String username);
     void CreateAccount(String username, String Password);

     void UpdateUserInfo(User user);

     void UpdateAvatar(String avatarUrl ,Integer id);

     void UpdatePwd(String newPwd, String username);
}
