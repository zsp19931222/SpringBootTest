package com.zsp.mapper;

import com.zsp.bean.StoreProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description:
 * author：Andy on 2020/12/2 0002-14:26
 * email:zsp872126510@gmail.com
 */
@Mapper
public interface ProductMapper {
    List<StoreProductEntity> productList();
}
