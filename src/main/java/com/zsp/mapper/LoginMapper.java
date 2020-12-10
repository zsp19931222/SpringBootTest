package com.zsp.mapper;

import com.zsp.entity.StoreUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * description:
 * author：Andy on 2020/11/16 0016-16:19
 * email:zsp872126510@gmail.com
 */
@Mapper
public interface LoginMapper {
    StoreUserEntity getUser(StoreUserEntity user);
    int registerUser(StoreUserEntity user);
    StoreUserEntity findUserByName(String userName);
}
