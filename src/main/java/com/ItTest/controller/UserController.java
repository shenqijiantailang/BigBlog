package com.ItTest.controller;

import com.ItTest.pojo.Result;
import com.ItTest.pojo.User;
import com.ItTest.service.UserService;
import com.ItTest.utils.JwtUtil;
import com.ItTest.utils.ThreadLocalUtil;
import io.netty.util.internal.StringUtil;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public Result login ( String username ,String password){

        User user =userService.findByUsername(username,password);
        if (user != null) {
            System.out.println(Result.success());
            Map<String, Object> claims= new HashMap<>();
            claims.put("ID",user.getId());
            claims.put("username",user.getUsername());
            String token = JwtUtil.genToken(claims);
            return  Result.success(token);
        }
        else {
            System.out.println(Result.error("账号或密码错误"));
            return  Result.error("账号或密码错误");
        }

    }
    @PostMapping("/register")
    public Result register (@Validated String username , String password) {
        User user =userService.ChekUniqueUsername(username);
        if (user != null) {
            return  Result.error("用户已存在");
        }
        else {
             userService.CreateAccount(username,password);
            return  Result.success();
        }
    }
    @GetMapping("/userInfo")
    public Result<User> userInfo(/*@RequestHeader(name = "Authorization")String token*/) {
//        Map<String, Object> map = JwtUtil.parseToken(token);
//        String  username = (String) map.get("username");
        Map<String,Object> map= ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user =userService.ChekUniqueUsername(username);
        return Result.success(user);
    }
    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        userService.UpdateUserInfo(user);
        return Result.success();
    }
    @PatchMapping("/updateAvatar")
    public  Result updateAvatar(@RequestParam @URL String avatarUrl){
        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("ID");
        userService.UpdateAvatar(avatarUrl,id);
        return  Result.success();

    }
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,Object> map ) {
        String oldPwd = (String) map.get("old_pwd");
        String newPwd = (String) map.get("new_pwd");
        String rePwd = (String) map.get("re_pwd");
        Map<String, Object> claims = ThreadLocalUtil.get();
        String username = (String) claims.get("username");
        if (StringUtil.isNullOrEmpty(oldPwd) || StringUtil.isNullOrEmpty(newPwd) || StringUtil.isNullOrEmpty(rePwd)) {
            System.out.println(oldPwd);
            System.out.println(newPwd);
            System.out.println(rePwd);
            return Result.error("请输入密码");
        } else {
            User user = userService.ChekUniqueUsername(username);
            if (!user.getPassword().equals(oldPwd)){
                return Result.error("旧密码不正确");
            } else {
                userService.UpdatePwd(newPwd,username);
            }
        }
        return Result.success();
    }

}
