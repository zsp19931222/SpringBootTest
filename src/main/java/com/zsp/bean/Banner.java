package com.zsp.bean;

import java.io.Serializable;

/**
 * description:
 * author：Andy on 2020/12/1 0001-15:04
 * email:zsp872126510@gmail.com
 */
public class Banner implements Serializable {
    private int bannerId;
    private String bannerPath;

    public Banner(int bannerId, String bannerPath) {
        this.bannerId = bannerId;
        this.bannerPath = bannerPath;
    }

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }
}
