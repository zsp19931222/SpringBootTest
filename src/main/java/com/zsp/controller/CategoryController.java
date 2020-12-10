package com.zsp.controller;

import com.zsp.error.ResultBody;
import com.zsp.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * description:
 * author:created by zsp on 2020/12/3 0003 14:52
 * email:zsp872126510@gmail.com
 */
@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Resource
    CategoryService categoryService;


    @GetMapping(value = "/getCategoryList")
    public ResultBody getCategoryList() {
        return ResultBody.success(categoryService.getCategoryList());
    }


}
