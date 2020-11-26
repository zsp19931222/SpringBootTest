package com.zsp.mapper;

import com.zsp.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description:
 * author：Andy on 2020/11/16 0016-16:19
 * email:zsp872126510@gmail.com
 */
@Mapper
public interface LoginMapper {

    User getUserById(int id);

    int insertUser(User user);

    List<User> getAllUser();

    User loginByUserName(@Param("name") String name, @Param("password") String password);

    int updateUser(User user);
}
