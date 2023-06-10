package com.bookshop.service;


import com.bookshop.pojo.CartItem;

import java.util.List;

@SuppressWarnings("all")
public interface CartItemService {
    /**
     * 添加商品项
     * @param cartItem
     */

    public void addItem(CartItem cartItem);
    /**
     * 删除商品项
     * @param id
     */

    public void deleteItem(Integer id,CartItem cartItem);
    /**
     * 清空购物车
     */

    public void clear(CartItem cartItem);

    /**
     * 修改商品数量
     * @param id
     * @param count
     */

    public void updateCount(Integer id,CartItem cartItem);

    /**
     * 查询购物车
     * @return
     */
    public List<CartItem> queryCart(Integer userid);


    /**
     * 查询购物车
     * @return
     */
    public List<CartItem> queryCartid(Integer id);
}
