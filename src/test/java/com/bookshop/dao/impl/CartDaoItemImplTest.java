package com.bookshop.dao.impl;

import com.bookshop.dao.CartItemDao;
import com.bookshop.pojo.CartItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CartDaoItemImplTest {
    private CartItemDao cartItemDao = new CartDaoItemImpl();

    /*
    * 1.添加图书
     */
    @Test
    void addItem() {
        cartItemDao.addItem(new CartItem(1,"1",1,new BigDecimal(1),1));

    }
    /*
    * 2.删除图书
     */
    @Test
    void deleteItem() {
        cartItemDao.deleteItem(1,new CartItem(1,"1",1,new BigDecimal(1),1));
    }

    /*
    * 3.清空购物车
     */
    @Test
    void clear() {
        cartItemDao.clear(new CartItem(1,"1",1,new BigDecimal(1),1));
    }

    /*
    * 4.修改图书数量
     */
    @Test
    void updateCount() {
        cartItemDao.updateCount(1,new CartItem(1,"1",1,new BigDecimal(1),1));
    }



    /*
    * 5.查询购物车是否存在
     */
    @Test
    void queryCartid() {
        cartItemDao.queryCartid(1);
    }
}