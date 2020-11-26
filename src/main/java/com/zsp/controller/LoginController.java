package com.zsp.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.zsp.bean.User;
import com.zsp.error.ResultBody;
import com.zsp.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * description:
 * author：Andy on 2020/11/16 0016-16:15
 * email:zsp872126510@gmail.com
 */
@Api(tags = "用户登录")
@RestController
public class LoginController {
    @Resource
    LoginService loginService;

    @GetMapping(value = "/getUser")
    public ResultBody getUser(int id) {
        return ResultBody.success(loginService.getUserById(id));
    }

    @PostMapping(value = "/registerUser")
    @ResponseBody
    public ResultBody saveUser(User user) {
        int i = loginService.insertUser(user);
        if (i > 0) {
            return ResultBody.success();
        } else {
            return ResultBody.error("注册失败");
        }

    }

    @GetMapping(value = "/saveAllUser")
    @ResponseBody
    public ResultBody saveUser() {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName("测试" + i);
            user.setPassword("admin");
            loginService.insertUser(user);
        }
        return ResultBody.success();
    }

    @GetMapping(value = "/getAllUser")
    public ResultBody getAllUser() {
        return ResultBody.success(loginService.getAllUser());
    }

    /*
     * @description: 登录
     * @author: Andy
     * @date: 2020/11/18 0018 10:17
     * @param null:
     * @return:
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public ResultBody login(String name, String password, HttpServletResponse response) {
        User user = loginService.loginByUserName(name, password);
        return ResultBody.success(user);
    }

    @ApiOperation("分页查询用户列表")
    @GetMapping(value = "/findAllUser")
    /*
     * @description:分页查询用户列表
     * @author: Andy
     * @date: 2020/11/23 0023 15:51
     * @param pageNo:
     * @param pageSize:
     * @return: com.example.zsp.SpringBootDemo.error.ResultBody
     */
    public ResultBody findAllUser(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return ResultBody.success(loginService.getAllUser());
    }
}
