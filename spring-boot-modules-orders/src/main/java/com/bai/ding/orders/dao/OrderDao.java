package com.bai.ding.orders.dao;

import com.bai.ding.orders.models.Order;
import com.bai.ding.orders.models.condition.QueryOrdersCondition;

import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/28 15:29
 */
public interface OrderDao {

    int getAllOrdersCount(QueryOrdersCondition condition);

    List<Order> getAllOrders(QueryOrdersCondition condition);
}
