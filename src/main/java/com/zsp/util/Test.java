package com.zsp.util;

import com.zsp.service.LoginService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * description:
 * author:created by zsp on 2020/12/11 0011 10:03
 * email:zsp872126510@gmail.com
 */
public class Test {

    public void test() {
        LoginService loginService=GetBeanUtil.getBean(LoginService.class);
        Log.info("-------------------------------进来了" + loginService);
    }
}
