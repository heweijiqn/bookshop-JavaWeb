/**
 * @version 1.0
 */


package com.bookshop.service.impl;

import com.bookshop.dao.CartItemDao;
import com.bookshop.dao.impl.CartDaoItemImpl;
import com.bookshop.pojo.CartItem;
import com.bookshop.service.CartItemService;

import java.util.List;

@SuppressWarnings("all")
public class CartItemSericeimpl implements CartItemService {

    private CartItemDao cartDao = new CartDaoItemImpl();
    @Override
    public void addItem(CartItem cartItem) {
        cartDao.addItem(cartItem);

    }

    @Override
    public void deleteItem(Integer id,CartItem cartItem) {
        cartDao.deleteItem(id,cartItem);

    }

    @Override
    public void clear(CartItem cartItem) {
        cartDao.clear(cartItem);


    }

    @Override
    public void updateCount(Integer id, CartItem cartItem) {
        cartDao.updateCount(id,cartItem);


    }

    @Override
    public List<CartItem> queryCart(Integer userid) {
        return cartDao.queryCart(userid);
    }

    @Override
    public List<CartItem> queryCartid(Integer id) {
        return cartDao.queryCartid(id);
    }


}
