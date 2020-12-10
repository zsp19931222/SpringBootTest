package com.zsp.jwt;

import com.zsp.error.ResultBody;
import com.zsp.util.IRedisService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * description:
 * author:created by zsp on 2020/12/4 0004 15:00
 * email:zsp872126510@gmail.com
 */
@Component
public class TokenAuthenticationService {
    static final long EXPIRATIONTIME = 24 * 60 * 60 * 1000;     // 5天
    static final String SECRET = "P@ssw02d";            // JWT密码
    static final String TOKEN_PREFIX = "";        // Token前缀
    static final String HEADER_STRING = "token";// 存放Token的Header Key
    @Autowired
    IRedisService iRedisService;

    // JWT生成方法
    public void addAuthentication(HttpServletResponse response, String username) {
        // 生成JWT
        String JWT = Jwts.builder()
                // 用户名写入标题
                .setSubject(username)
                // 有效期设置
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                // 签名设置
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        iRedisService.set(username, JWT, System.currentTimeMillis() + EXPIRATIONTIME);
        // 将 JWT 写入 body
        ResultBody.writeJSON2Response(ResultBody.success(JWT), response);
    }

    // JWT验证方法
    public Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) {
        // 从Header中拿到token
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // 解析 Token
            try {
                Claims claims = Jwts.parser()
                        // 验签
                        .setSigningKey(SECRET)
                        // 去掉 Bearer
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody();

                // 拿用户名
                String user = claims.getSubject();
                //判断与Redis存储的token是否一致，不一致说明重新获取了token
                if (token.equals(iRedisService.get(user))) {
                    // 返回验证令牌
                    return user != null ?
                            new UsernamePasswordAuthenticationToken(user, null, null) :
                            null;
                } else {
                    ResultBody.writeJSON2Response(ResultBody.error("无效token"), response);
                    return null;
                }
            } catch (Exception e) {
                ResultBody.writeJSON2Response(ResultBody.error("无效token"), response);
                return null;
            }
        }
        return null;
    }
}
