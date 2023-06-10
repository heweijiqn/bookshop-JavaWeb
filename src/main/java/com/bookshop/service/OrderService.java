package com.bookshop.service;

import com.bookshop.pojo.Order;

import java.util.List;

public interface OrderService {
    /**
     * 查询订单
     * @return
     */
    public List<Order> queryOrder();

    /**
     * 保存订单
     * @param order
     */
    public void saveOrder(Order order);

    /**
     * 删除订单
     * @param orderid
     */
    public void deleteOrder(Integer orderid);
}
