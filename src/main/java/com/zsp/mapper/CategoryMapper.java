package com.zsp.mapper;

import com.zsp.entity.StoreCategoryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description:
 * author:created by zsp on 2020/12/3 0003 14:47
 * email:zsp872126510@gmail.com
 */
@Mapper
public interface CategoryMapper {
    List<StoreCategoryEntity> getCategoryList();
}
