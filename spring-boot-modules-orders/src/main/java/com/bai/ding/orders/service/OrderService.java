package com.bai.ding.orders.service;

import com.bai.ding.common.Result;
import com.bai.ding.orders.models.condition.QueryOrdersCondition;

/**
 * @author BaiDing
 * @date 2020/3/28 15:28
 */
public interface OrderService {

    /**
     * 查询订单列表分页数据
     * @param condition
     * @return
     */
    Result getAllOrders(QueryOrdersCondition condition);
}
