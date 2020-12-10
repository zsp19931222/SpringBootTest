package com.zsp.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * description:
 * author：Andy on 2020/12/2 0002-14:22
 * email:zsp872126510@gmail.com
 */
@Data
public class StoreProductEntity implements Serializable {
    private int id;
    private int categoryId;
    private String name;
    private String subtitle;
    private String mainImage;
    private String subImages;
    private String detail;
    private BigDecimal price;
    private int stock;
    private Integer status;
    private Timestamp createTime;
    private Timestamp updateTime;
    private int quantity;
}
