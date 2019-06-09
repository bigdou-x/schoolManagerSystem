package com.bigdou.xuqing.controller;

import com.bigdou.xuqing.entity.User;
import com.bigdou.xuqing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 描述：查询所有用户
     */
    @RequestMapping("/queryUserAll")
    public List<User> queryUserAll() {
        return userService.listUser();
    }

    @RequestMapping("/addUser")
    public void addUser(@RequestParam(name = "userName") String userName,
                        @RequestParam(name = "password") String password) {
        userService.addUser(User.builder().userName(userName).password(password).build());
    }

}
