/**
 * @version 1.0
 */


package com.bookshop.dao.impl;

import com.bookshop.dao.CartDao;
import com.bookshop.pojo.Cart;



public class CartDaoImpl extends BasicDAO<Cart> implements CartDao {
    @Override
    public Cart queryCart(Integer userid) {//根据用户id查询购物车
        String sql = "select * from t_cart where userid = ?";
        return querySingle(sql,Cart.class,userid);
    }

    @Override
    public boolean isExist(Integer userid) {
        //判断是否存在该用户
        String sql = "select *from t_cart where userid = ?";
        Cart cart = querySingle(sql, Cart.class, userid);
        //如果存在返回true
        if(cart != null){
            return true;
        }else {
            //如果不存在返回创建 该用户的购物车
            String add = "insert into t_cart(`userid`,`totalPrice`,`totalCount`) values(?,?,?)";
            update(add,userid,0,0);
            return false;
        }

    }



}
