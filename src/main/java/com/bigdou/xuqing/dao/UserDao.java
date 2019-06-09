package com.bigdou.xuqing.dao;

import com.bigdou.xuqing.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {
}
