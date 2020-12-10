package com.zsp.config;

import com.zsp.jwt.CustomAuthenticationProvider;
import com.zsp.jwt.JWTAuthenticationFilter;
import com.zsp.jwt.JWTLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * description:
 * author:created by zsp on 2020/12/4 0004 14:58
 * email:zsp872126510@gmail.com
 */
@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    CustomAuthenticationProvider provider;
    @Autowired
    JWTAuthenticationFilter jwtAuthenticationFilter;
    @Bean
    JWTLoginFilter jwtLoginFilter() throws Exception {
        return new JWTLoginFilter("/login/getToken", authenticationManager());
    }
    // 设置 HTTP 验证规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭csrf验证
        http.csrf().disable()
                // 对请求进行认证
                .authorizeRequests()
//                // 所有 / 的所有请求 都放行
//                .antMatchers("/").permitAll()
                // 所有 /login 的POST请求 都放行
                .antMatchers("/login/getToken", "/login/register", "/category/*", "/product/*", "/banner/*").permitAll()
//                // 权限检查
//                .antMatchers("/hello").hasAuthority("AUTH_WRITE")
//                // 角色检查
//                .antMatchers("/world").hasRole("ADMIN")
                // 所有请求需要身份认证
                .anyRequest().authenticated()
                .and()
                // 添加一个过滤器 所有访问 /login 的请求交给 JWTLoginFilter 来处理 这个类处理所有的JWT相关内容
                .addFilterBefore(jwtLoginFilter(),
                        UsernamePasswordAuthenticationFilter.class)
                // 添加一个过滤器验证其他请求的Token是否合法
                .addFilterBefore(jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义身份验证组件
        auth.authenticationProvider(provider);

    }
}
