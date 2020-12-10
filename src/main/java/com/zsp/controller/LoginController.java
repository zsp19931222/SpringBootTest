package com.zsp.controller;

import com.zsp.entity.StoreUserEntity;
import com.zsp.error.ResultBody;
import com.zsp.service.LoginService;
import com.zsp.util.IsNullUtil;
import com.zsp.util.Log;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * description:
 * author：Andy on 2020/11/16 0016-16:15
 * email:zsp872126510@gmail.com
 */
@Api(tags = "用户登录")
@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @Resource
    LoginService loginService;

    @PostMapping(value = "/getToken")
    @ResponseBody
    /**
     * @description: 获取token
     * @author: zsp
     * @date: 2020/12/4 0004 16:51
     * @param loginUser
     * @param response
     * @return: com.zsp.error.ResultBody
     */
    public void getToken() {

    }

    @PostMapping(value = "/getUserInfo")
    @ResponseBody
    /**
     * @description: 根据token验证是否登录并获取用户信息
     * @author: zsp
     * @date: 2020/12/4 0004 16:50
     * @param loginUser
     * @param response
     * @return: com.zsp.error.ResultBody
     */
    public ResultBody getUserInfo(@RequestBody StoreUserEntity loginUser) {
        return ResultBody.success(loginService.getUser(loginUser));
    }


    @PostMapping(value = "/register")
    @ResponseBody
    public ResultBody register(@RequestBody @Valid StoreUserEntity user) {
        if (!IsNullUtil.getInstance().isEmpty(loginService.findUserByName(user.getUsername()))) {
            return ResultBody.error("该用户名已被注册");
        } else {
            user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            user.setCreateTime(new Timestamp(System.currentTimeMillis()));
            user.setRole(0);
            if (loginService.registerUser(user) > 0) {
                return ResultBody.success("注册成功");
            } else {
                return ResultBody.error("注册失败");
            }
        }
    }
}
