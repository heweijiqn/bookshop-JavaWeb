package com.bookshop.service;

import com.bookshop.pojo.Cart;


public interface CartService {
    /**
     * 查询购物车
     * @param userid
     * @return
     */
   public Cart queryCart(Integer userid);

    /**
     *  查询用户是否存在
     *  @param userid
     */
    public boolean isExist(Integer userid);





}
