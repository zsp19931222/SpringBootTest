package com.zsp.jwt;

import com.zsp.entity.StoreUserEntity;
import com.zsp.service.LoginService;
import com.zsp.util.IsNullUtil;
import com.zsp.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * description:拦截用户获取token并判断是否合法
 * author:created by zsp on 2020/12/4 0004 15:04
 * email:zsp872126510@gmail.com
 */
// 自定义身份认证验证组件
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    LoginService loginService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取认证的用户名 & 密码
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        //查询用户
        StoreUserEntity userEntity = loginService.findUserByName(name);
        // 认证逻辑
        if (IsNullUtil.getInstance().isEmpty(userEntity)){
            throw new BadCredentialsException("用户不存在");
        }
        //用户名密码匹对
        if (name.equals(userEntity.getUsername()) && password.equals(userEntity.getPassword())) {
            // 这里设置权限和角色
            ArrayList<GrantedAuthority> authorities = new ArrayList<>();
            // 生成令牌
            Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
            return auth;
        } else {
            throw new BadCredentialsException("账号或密码错误~");
        }
    }

    // 是否可以提供输入类型的认证服务
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
