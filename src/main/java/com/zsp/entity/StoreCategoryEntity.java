package com.zsp.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * description:
 * author:created by zsp on 2020/12/3 0003 14:45
 * email:zsp872126510@gmail.com
 */
@Data
public class StoreCategoryEntity implements Serializable {
    private int id;
    private Integer parentId;
    private String name;
    private Byte status;
    private Integer sortOrder;
    private Timestamp createTime;
    private Timestamp updateTime;

}
