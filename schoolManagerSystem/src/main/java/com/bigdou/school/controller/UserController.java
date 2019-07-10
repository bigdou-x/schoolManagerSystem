package com.bigdou.school.controller;

import com.bigdou.school.entity.Result;
import com.bigdou.school.entity.User;
import com.bigdou.school.mapper.UserMapper;
import com.bigdou.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    /**
     * 描述：查询所有用户
     */
    @RequestMapping("/queryUserAll")
    public Result queryUserAll() {
        return userService.listUser();
    }

    @RequestMapping("/addUser")
    public Result addUser(@RequestParam(name = "userName") String userName,
                        @RequestParam(name = "password") String password) {
        return userService.saveUser(User.builder().userName(userName).password(password).build());
    }

    @RequestMapping("/findUserById")
    public Result findUserById(@RequestParam(name = "id") Long id) {
        return userService.findUserById(id);
    }

    @RequestMapping("/findById")
    public User findById(@RequestParam(name = "id") Long id) {
        return userMapper.findById(id);
    }

    @RequestMapping("/login")
    public Result login(@RequestParam(name = "userName") String userName,
                         @RequestParam(name = "password") String password) {
        return userService.login(userName, password);
    }
}
