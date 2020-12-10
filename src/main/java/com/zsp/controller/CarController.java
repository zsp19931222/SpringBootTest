package com.zsp.controller;

import com.zsp.entity.StoreCartEntity;
import com.zsp.error.ResultBody;
import com.zsp.service.CarService;
import com.zsp.util.Log;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * description:
 * author:created by zsp on 2020/12/9 0009 15:53
 * email:zsp872126510@gmail.com
 */
@RestController
@RequestMapping(value = "/car")
public class CarController {
    @Resource
    CarService carService;


    @PostMapping(value = "/addProduct")
    @ResponseBody
    public ResultBody addProduct(@RequestBody StoreCartEntity cartEntity) {
        cartEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        cartEntity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        int i = carService.addProduct(cartEntity);
        if (i > 0) {
            return ResultBody.success("添加成功");
        } else {
            return ResultBody.error("添加失败");
        }
    }

    @GetMapping(value = "/getCartList/{userId}")
    @ResponseBody
    public ResultBody getCartList(@NotNull @PathVariable(value = "userId") int useId) {
        return ResultBody.success(carService.getProductList(useId));
    }
}
