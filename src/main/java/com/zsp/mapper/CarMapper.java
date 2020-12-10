package com.zsp.mapper;

import com.zsp.entity.StoreCartEntity;
import com.zsp.entity.StoreProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description:
 * author:created by zsp on 2020/12/9 0009 15:39
 * email:zsp872126510@gmail.com
 */
@Mapper
public interface CarMapper {
    /**
    * @description: 添加到购物车
    * @author: zsp
    * @date: 2020/12/9 0009 15:46
    * @param null
    * @return:
    */
    int addProduct(StoreCartEntity cartEntity);

    List<StoreProductEntity> getProductList(@Param(value = "userId") int userId);
}
