package com.bai.ding.orders.models;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author BaiDing
 * @date 2020/3/28 15:17
 */
public class Order {

    private long id;
    private long userId;
    private String orderNumber;
    private Double orderPrice;
    /**
     * 支付方式
     */
    private int orderPay;
    /**
     * 是否发货
     */
    private String send;
    private String tradeNo;
    /**
     * 发票标题
     */
    private String orderFapiaoTitle;
    private String orderFapiaoCompany;
    private String orderFgapiaoContent;
    private String consigneeAddr;
    private int payStatus;

    private long createTime;
    private long updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getOrderPay() {
        return orderPay;
    }

    public void setOrderPay(int orderPay) {
        this.orderPay = orderPay;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOrderFapiaoTitle() {
        return orderFapiaoTitle;
    }

    public void setOrderFapiaoTitle(String orderFapiaoTitle) {
        this.orderFapiaoTitle = orderFapiaoTitle;
    }

    public String getOrderFapiaoCompany() {
        return orderFapiaoCompany;
    }

    public void setOrderFapiaoCompany(String orderFapiaoCompany) {
        this.orderFapiaoCompany = orderFapiaoCompany;
    }

    public String getOrderFgapiaoContent() {
        return orderFgapiaoContent;
    }

    public void setOrderFgapiaoContent(String orderFgapiaoContent) {
        this.orderFgapiaoContent = orderFgapiaoContent;
    }

    public String getConsigneeAddr() {
        return consigneeAddr;
    }

    public void setConsigneeAddr(String consigneeAddr) {
        this.consigneeAddr = consigneeAddr;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public String getCreateTime() {
        LocalDateTime time =LocalDateTime.ofInstant(Instant.ofEpochMilli(this.createTime), ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return time.format(formatter);
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        LocalDateTime time =LocalDateTime.ofInstant(Instant.ofEpochMilli(this.updateTime), ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return time.format(formatter);
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }
}
