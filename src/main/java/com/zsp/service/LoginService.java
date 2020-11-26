package com.zsp.service;

import com.zsp.bean.User;
import com.zsp.mapper.LoginMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 * author：Andy on 2020/11/16 0016-16:19
 * email:zsp872126510@gmail.com
 */
@Service
@Transactional
public class LoginService {
    @Resource
    LoginMapper loginMapper;

    @Cacheable(value = "emp", key = "#id")
    public User getUserById(int id) {
        System.out.println("缓存不存在，执行方法");
        return loginMapper.getUserById(id);
    }

    /*
     * @description: 注册
     * @author: Andy
     * @date: 2020/11/18 0018 10:23
     * @param null:
     * @return:
     */
    public int insertUser(User user) {
        return loginMapper.insertUser(user);
    }

    public List<User> getAllUser() {
        return loginMapper.getAllUser();
    }

    /*
     * @description: 登录
     * @author: Andy
     * @date: 2020/11/18 0018 10:23
     * @param null:
     * @return:
     */
    public User loginByUserName(String name, String password) {
        return loginMapper.loginByUserName(name, password);
    }

    public int updateUser(User user){
        return loginMapper.updateUser(user);
    }
}
