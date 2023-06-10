package com.bookshop.dao.impl;

import com.bookshop.dao.OrderDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderDaoImplTest {

    private OrderDao orderDao = new OrderDaoImpl();

    @Test
    void queryOrders() {
    }

    @Test
    void saveOrder() {
    }

    @Test
    void deleteOrder() {
        orderDao.deleteOrder(1);
    }
}