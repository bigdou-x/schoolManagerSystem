package com.bigdou.school.dao;

import com.bigdou.school.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<User, Long> {

    User findUserById(Long id);

    List<User> findUsersByUserNameAndPassword(String userName, String password);

}
