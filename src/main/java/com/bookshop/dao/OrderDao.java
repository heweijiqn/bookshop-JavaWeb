package com.bookshop.dao;

import com.bookshop.pojo.Order;

import java.util.List;

public interface OrderDao {

    /**
     * 查询所有订单
     * @return
     */
    public List<Order> queryOrders();
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
