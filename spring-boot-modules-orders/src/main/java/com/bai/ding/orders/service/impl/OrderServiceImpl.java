package com.bai.ding.orders.service.impl;

import com.bai.ding.common.Page;
import com.bai.ding.common.Result;
import com.bai.ding.orders.dao.OrderDao;
import com.bai.ding.orders.models.Order;
import com.bai.ding.orders.models.condition.QueryOrdersCondition;
import com.bai.ding.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/28 15:29
 */
@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    @Override
    public Result getAllOrders(QueryOrdersCondition condition) {
        int count = orderDao.getAllOrdersCount(condition);
        List<Order> list = orderDao.getAllOrders(condition);
        Page<Order> page = new Page.Builder<Order>().setPageNow(condition.getCurrent())
                .setPageSize(condition.getPageSize()).setRecordTotal(count).setList(list).build();
        return new Result.Builder().ok().setMessage("订单列表如下：").setData(page).build();
    }

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
