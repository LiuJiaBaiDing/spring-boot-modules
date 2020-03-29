package com.bai.ding.orders.models.condition;

import com.bai.ding.common.BaseQueryCondition;

/**
 * @author BaiDing
 * @date 2020/3/28 15:27
 */
public class QueryOrdersCondition extends BaseQueryCondition {

    private String orderNumber;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
