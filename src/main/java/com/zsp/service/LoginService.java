package com.zsp.service;

import com.zsp.entity.StoreUserEntity;
import com.zsp.mapper.LoginMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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

    public StoreUserEntity getUser(StoreUserEntity user){
        return loginMapper.getUser(user);
    }


    public int registerUser(StoreUserEntity user){
     return loginMapper.registerUser(user);
    }

    public StoreUserEntity findUserByName(String userName){
        return loginMapper.findUserByName(userName);
    }

}
