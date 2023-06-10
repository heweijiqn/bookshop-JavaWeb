package com.bookshop.dao.impl;

import com.bookshop.dao.CartDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartDaoImplTest {
    private CartDao cartDao = new CartDaoImpl();

    /*
    * 1.添加图书
     */
    @Test
    void queryCart() {
        System.out.println(cartDao.queryCart(1));

    }
    /*
    * 2.判断购物车是否存在
     */
    @Test
    void isExist() {
        System.out.println(cartDao.isExist(1));
    }
}