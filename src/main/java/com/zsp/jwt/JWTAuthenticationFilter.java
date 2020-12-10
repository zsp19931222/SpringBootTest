package com.zsp.jwt;

import com.zsp.util.IsNullUtil;
import com.zsp.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description:认证过滤器
 * author:created by zsp on 2020/12/4 0004 15:09
 * email:zsp872126510@gmail.com
 */
@Component
public class JWTAuthenticationFilter extends GenericFilterBean {
    @Autowired
    TokenAuthenticationService tokenAuthenticationService;

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {
        Authentication authentication = tokenAuthenticationService
                .getAuthentication((HttpServletRequest) request, (HttpServletResponse) response);
        if (!IsNullUtil.getInstance().isEmpty(authentication)) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
        }
    }
}

