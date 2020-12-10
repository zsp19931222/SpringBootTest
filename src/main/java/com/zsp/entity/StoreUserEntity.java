package com.zsp.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

/**
 * description:
 * author:created by zsp on 2020/12/4 0004 16:30
 * email:zsp872126510@gmail.com
 */
@Data
public class StoreUserEntity {
    private int id;
    @NotNull(message = "用户名不能为null")
    private String username;
    @NotNull
//    @Length(max = 50  ,message = "密码长度为0-50之间")
//    @Pattern(regexp = "[^Zz]\\w{5,8}")
    private String password;
    private String email;
    @Pattern(regexp = "^1[3-9]\\d{9}")
    private String phone;
    private String question;
    private String answer;
    private int role;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String photo;

}
