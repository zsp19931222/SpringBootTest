package com.zsp.controller;

import com.zsp.error.ResultBody;
import com.zsp.service.BannerService;
import com.zsp.util.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * description:
 * author：Andy on 2020/12/1 0001-15:29
 * email:zsp872126510@gmail.com
 */
@RequestMapping(value = "/banner")
@RestController
public class BannerController {
    @Resource
    BannerService bannerService;

    @ResponseBody
    @GetMapping(value = "/getBanner")
    public ResultBody getBanner() {
        return ResultBody.success(bannerService.getBannerList());
    }
}
