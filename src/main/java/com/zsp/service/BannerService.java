package com.zsp.service;

import com.zsp.bean.Banner;
import com.zsp.mapper.BannerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 * author：Andy on 2020/12/1 0001-15:28
 * email:zsp872126510@gmail.com
 */
@Service
public class BannerService {
    @Resource
    BannerMapper bannerMapper;

    public List<Banner> getBannerList() {
        return bannerMapper.getBannerList();
    }
}
