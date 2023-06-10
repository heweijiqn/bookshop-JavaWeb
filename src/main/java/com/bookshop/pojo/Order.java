/**
 * @author 何伟健
 * @version 1.0
 * @date 2023/6/3 23:23
 */


package com.bookshop.pojo;


public class Order {
    private Integer orderid;

    private Integer userid;

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", userid=" + userid +
                '}';
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Order() {
    }

    public Order(Integer orderid, Integer userid) {
        this.orderid = orderid;
        this.userid = userid;
    }
}
