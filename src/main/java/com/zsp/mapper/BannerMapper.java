package com.zsp.mapper;

import com.zsp.entity.Banner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description:
 * author：Andy on 2020/12/1 0001-15:23
 * email:zsp872126510@gmail.com
 */
@Mapper
public interface BannerMapper {
    List<Banner> getBannerList();
}
