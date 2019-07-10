package com.bigdou.school.mapper;

import com.bigdou.school.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * <P>文件描述：user表的映射</P>
 *
 * @author xuqing
 * @version V1.0
 * @date 2019-7-8 00:03:24
 */
public interface UserMapper {

    @Insert("insert into t_user (user_name, password, gmt_create, gmt_modified) " +
            "values (#{userName}, #{password}, now(), now())")
    @Options(useGeneratedKeys = true)
    int save(User user);

    @Select("select * from t_user where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "create_time", property = "createTime"),
    })
    User findById(@Param("id") Long id);

}
