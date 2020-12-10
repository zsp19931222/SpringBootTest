package com.zsp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * description:
 * author：Andy on 2020/12/1 0001-15:04
 * email:zsp872126510@gmail.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banner implements Serializable {
    private int bannerId;
    private String bannerPath;
}
