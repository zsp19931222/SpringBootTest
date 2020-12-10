package com.zsp.service;

import com.zsp.entity.StoreProductEntity;
import com.zsp.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 * author：Andy on 2020/12/2 0002-14:31
 * email:zsp872126510@gmail.com
 */
@Service
public class ProductService {
    @Resource
    ProductMapper productMapper;

    public List<StoreProductEntity> productEntityList() {
        return productMapper.productList();
    }

    public List<StoreProductEntity> getProductListById(int categoryId) {
        return productMapper.getProductListById(categoryId);
    }
}
