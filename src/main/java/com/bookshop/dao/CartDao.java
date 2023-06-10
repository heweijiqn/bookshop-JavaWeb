package com.bookshop.dao;

import com.bookshop.pojo.Cart;

public interface CartDao {

    /**
     * 根据用户id查询购物车
     * @param userid
     * @return
     */
    public Cart queryCart(Integer userid);

    /**
     * 是否存在该用户
     */
    public boolean isExist(Integer userid);





}
