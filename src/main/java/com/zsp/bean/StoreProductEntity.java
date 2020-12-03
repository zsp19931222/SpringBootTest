package com.zsp.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * description:
 * author：Andy on 2020/12/2 0002-14:22
 * email:zsp872126510@gmail.com
 */
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

    public StoreProductEntity(int id, int categoryId, String name, String subtitle, String mainImage, String subImages, String detail, BigDecimal price, int stock, Integer status, Timestamp createTime, Timestamp updateTime) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.subtitle = subtitle;
        this.mainImage = mainImage;
        this.subImages = subImages;
        this.detail = detail;
        this.price = price;
        this.stock = stock;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getSubImages() {
        return subImages;
    }

    public void setSubImages(String subImages) {
        this.subImages = subImages;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreProductEntity that = (StoreProductEntity) o;
        return id == that.id &&
                categoryId == that.categoryId &&
                stock == that.stock &&
                Objects.equals(name, that.name) &&
                Objects.equals(subtitle, that.subtitle) &&
                Objects.equals(mainImage, that.mainImage) &&
                Objects.equals(subImages, that.subImages) &&
                Objects.equals(detail, that.detail) &&
                Objects.equals(price, that.price) &&
                Objects.equals(status, that.status) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryId, name, subtitle, mainImage, subImages, detail, price, stock, status, createTime, updateTime);
    }
}
