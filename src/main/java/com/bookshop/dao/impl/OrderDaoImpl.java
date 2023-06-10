/**
 * @author 何伟健
 * @version 1.0
 * @date 2023/6/3 23:27
 */


package com.bookshop.dao.impl;

import com.bookshop.dao.OrderDao;
import com.bookshop.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BasicDAO<Order> implements OrderDao {


    @Override
    public List<Order> queryOrders() {
        String sql = "select * from t_order";
        return queryMulti(sql, Order.class);
    }

    @Override
    public void saveOrder(Order order) {
       String sql = "insert into t_order(orderid,  userid) values(?,?)";
       update(sql, order.getOrderid(), order.getUserid());
       String cart = "delete from t_cart where userid = ?";
       update(cart,order.getUserid());
       String cartItem = "delete from t_cart_item where userid = ?";
       update(cartItem,order.getUserid());

    }

    @Override
    public void deleteOrder(Integer orderid) {
        String sql = "delete from t_order where orderid = ?";
        update(sql,orderid);
    }

}
