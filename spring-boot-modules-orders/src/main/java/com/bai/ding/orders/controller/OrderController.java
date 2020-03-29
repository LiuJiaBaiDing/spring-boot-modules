package com.bai.ding.orders.controller;

import com.bai.ding.common.Result;
import com.bai.ding.orders.models.condition.QueryOrdersCondition;
import com.bai.ding.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BaiDing
 * @date 2020/3/28 15:18
 */
@RestController
public class OrderController {

    private OrderService orderService;

    @GetMapping("/orders")
    public Result getAllOrders(QueryOrdersCondition condition){
        return orderService.getAllOrders(condition);
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
