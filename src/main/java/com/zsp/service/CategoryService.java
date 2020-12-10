package com.zsp.service;

import com.zsp.entity.StoreCategoryEntity;
import com.zsp.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 * author:created by zsp on 2020/12/3 0003 14:51
 * email:zsp872126510@gmail.com
 */
@Service
public class CategoryService {
    @Resource
    CategoryMapper categoryMapper;

    public List<StoreCategoryEntity> getCategoryList() {
        return categoryMapper.getCategoryList();
    }
}
