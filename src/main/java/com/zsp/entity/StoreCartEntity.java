package com.zsp.entity;

import lombok.Data;
import lombok.NonNull;

import java.sql.Timestamp;

/**
 * description:
 * author:created by zsp on 2020/12/9 0009 15:37
 * email:zsp872126510@gmail.com
 */
@Data
public class StoreCartEntity {
    private int id;
    @NonNull
    private int userId;
    @NonNull
    private Integer productId;
    @NonNull
    private Integer quantity;
    @NonNull
    private Integer checked;
    private Timestamp createTime;
    private Timestamp updateTime;
}
