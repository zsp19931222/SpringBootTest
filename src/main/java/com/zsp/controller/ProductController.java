package com.zsp.controller;

import com.github.pagehelper.PageHelper;
import com.zsp.error.ResultBody;
import com.zsp.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * description:
 * author：Andy on 2020/12/2 0002-14:32
 * email:zsp872126510@gmail.com
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Resource
    ProductService productService;

    @GetMapping(value = "/getProductList")
    @ResponseBody
    public ResultBody getProductList(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return ResultBody.success(productService.productEntityList());
    }

    @GetMapping(value = "/getProductListById/{categoryId}")
    @ResponseBody
    /**
     * @description: 根据categoryId获取相应数据
     * @author: zsp
     * @date: 2020/12/3 0003 15:13
     * @param categoryId
     * @return: com.zsp.error.ResultBody
     */
    public ResultBody getProductListById(@PathVariable("categoryId") Integer categoryId) {
        return ResultBody.success(productService.getProductListById(categoryId));
    }
}
