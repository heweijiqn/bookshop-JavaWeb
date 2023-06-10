/**
 * @author 何伟健
 * @version 1.0
 * @date 2023/6/3 23:29
 */


package com.bookshop.service.impl;

import com.bookshop.dao.OrderDao;
import com.bookshop.dao.impl.OrderDaoImpl;
import com.bookshop.pojo.Order;
import com.bookshop.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();


    @Override
    public List<Order> queryOrder() {
        return orderDao.queryOrders();
    }

    @Override
    public void saveOrder(Order order) {
        orderDao.saveOrder(order);
    }

    @Override
    public void deleteOrder(Integer orderid) {
        orderDao.deleteOrder(orderid);
    }
}
