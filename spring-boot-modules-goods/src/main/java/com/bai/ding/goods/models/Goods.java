package com.bai.ding.goods.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author BaiDing
 * @date 2020/3/26 18:11
 */
public class Goods {
    private long id;
    private long categoryId;
    private String goodsName;
    private double goodsPrice;
    private double goodsWeight;
    /**
     * 商品数量
     */
    private int goodsNumber;
    /**
     * 商品更新时间
     */
    private long updateTime;
    private long createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public double getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(double goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getUpdateTime() {
        LocalDateTime time =LocalDateTime.ofInstant(Instant.ofEpochMilli(this.updateTime), ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return time.format(formatter);
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        LocalDateTime time =LocalDateTime.ofInstant(Instant.ofEpochMilli(this.createTime), ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return time.format(formatter);
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
