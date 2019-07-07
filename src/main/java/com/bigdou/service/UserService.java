package com.bigdou.service;

import cn.hutool.core.util.StrUtil;
import com.bigdou.dao.UserDao;
import com.bigdou.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> listUser() {
        List<User> listUser = new ArrayList<>();
        userDao.findAll().forEach(row -> {
            listUser.add(User.builder().id(row.getId()).userName(row.getUserName())
                    .password(row.getPassword()).createTime(row.getCreateTime())
                    .updateTime(row.getUpdateTime()).build());
        });
        return listUser;
    }

    public void addUser(User user) {
        if (user == null) {
            log.error("addUser user is null");
            return;
        }
        if (StrUtil.isEmpty(user.getUserName())) {
            log.error("addUser userName is null");
            return;
        }
        if (StrUtil.isEmpty(user.getPassword())) {
            log.error("addUser password is null");
            return;
        }
        User userEntity = User.builder().userName(user.getUserName()).password(user.getPassword()).build();
        userDao.save(userEntity);
    }

}
