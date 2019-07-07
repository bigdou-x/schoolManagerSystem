package com.bigdou.controller;

import com.bigdou.entity.User;
import com.bigdou.mapper.UserMapper;
import com.bigdou.service.UserService;
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

    @Autowired
    private UserMapper userMapper;

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

    @RequestMapping("/findById")
    public User findById(@RequestParam(name = "id") Long id) {
        return userMapper.findById(id);
    }
}
