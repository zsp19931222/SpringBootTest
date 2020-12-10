package com.zsp.service;

import com.zsp.entity.StoreCartEntity;
import com.zsp.entity.StoreProductEntity;
import com.zsp.mapper.CarMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 * author:created by zsp on 2020/12/9 0009 15:52
 * email:zsp872126510@gmail.com
 */
@Service
public class CarService {
    @Resource
    CarMapper carMapper;

    public int addProduct(StoreCartEntity cartEntity) {
        return carMapper.addProduct(cartEntity);
    }

    public List<StoreProductEntity> getProductList(int userId){
        return carMapper.getProductList(userId);
    }
}
