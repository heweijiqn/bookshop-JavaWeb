/**
 * @version 1.0
 */


package com.bookshop.service.impl;


import com.bookshop.dao.CartDao;
import com.bookshop.dao.impl.CartDaoImpl;
import com.bookshop.pojo.Cart;
import com.bookshop.service.CartService;



public class CartServiceImpl implements CartService {
   private CartDao cartDao = new CartDaoImpl();

    @Override
    public Cart queryCart(Integer userid) {
        return cartDao.queryCart(userid);

    }

    @Override
    public boolean isExist(Integer userid) {
        return cartDao.isExist(userid);
    }




}


