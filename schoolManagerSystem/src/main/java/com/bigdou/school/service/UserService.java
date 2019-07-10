package com.bigdou.school.service;

import cn.hutool.core.util.StrUtil;
import com.bigdou.school.dao.UserDao;
import com.bigdou.school.entity.Result;
import com.bigdou.school.entity.User;
import com.bigdou.school.type.ErrorCodeEnum;
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

    /**
     * 方法描述: 查询所有用户
     *
     * @author xuqing 04765
     * @date 2019/7/9 18:41
     * @return Result
     */
    public Result listUser() {
        List<User> listUser = new ArrayList<>();
        userDao.findAll().forEach(row -> {
            listUser.add(User.builder().id(row.getId()).userName(row.getUserName())
                    .password(row.getPassword()).createTime(row.getCreateTime())
                    .updateTime(row.getUpdateTime()).build());
        });
        return Result.builder().content(listUser).ret(ErrorCodeEnum.OK.ordinal()).build();
    }

    /**
     * 方法描述: 保存用户
     *
     * @author xuqing 04765
     * @date 2019/7/9 18:41
     * @return Result
     */
    public Result saveUser(User user) {
        Result result = new Result();
        if (user == null) {
            log.error("addUser user is null");
            result.setRet(ErrorCodeEnum.ERROR_PARAM.ordinal());
            return result;
        }
        if (StrUtil.isEmpty(user.getUserName())) {
            log.error("addUser userName is null");
            result.setRet(ErrorCodeEnum.ERROR_PARAM.ordinal());
            return result;
        }
        if (StrUtil.isEmpty(user.getPassword())) {
            log.error("addUser password is null");
            result.setRet(ErrorCodeEnum.ERROR_PARAM.ordinal());
            return result;
        }
        User userEntity = User.builder().userName(user.getUserName()).password(user.getPassword()).build();
        userDao.save(userEntity);
        result.setRet(ErrorCodeEnum.OK.ordinal());
        return result;
    }

    /**
     * 方法描述: 通过Id删除用户
     *
     * @author xuqing 04765
     * @date 2019/7/9 18:47
     * @return Result
     */
    public Result deleteUserById(Long id) {
        Result result = new Result();
        if (id == null) {
            log.error("deleteUserById id is null {}", id);
            result.setRet(ErrorCodeEnum.ERROR_PARAM.ordinal());
            return result;
        }
        userDao.deleteById(id);
        result.setRet(ErrorCodeEnum.OK.ordinal());
        return result;
    }

    /**
     * 方法描述: 通过Id查询用户
     *
     * @author xuqing 04765
     * @date 2019/7/9 19:16
     * @return Result
     */
    public Result findUserById(Long id) {
        Result result = new Result();
        if (id == null) {
            log.error("findUserById id is null {}",id);
            result.setRet(ErrorCodeEnum.ERROR_PARAM.ordinal());
            return result;
        }
        result.setContent(userDao.findUserById(id));
        result.setRet(ErrorCodeEnum.OK.ordinal());
        return result;
    }

    public Result login(String userName, String password) {
        Result result = new Result();
        if (StrUtil.isEmpty(userName) || StrUtil.isEmpty(password)) {
            log.error("login userName or password is null {}, {}", userName, password);
            result.setRet(ErrorCodeEnum.ERROR_PARAM.ordinal());
            return result;
        }
        result.setContent(userDao.findUsersByUserNameAndPassword(userName, password));
        result.setRet(ErrorCodeEnum.OK.ordinal());
        return result;
    }

}
