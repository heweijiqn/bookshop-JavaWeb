/**
 * @version 1.0
 */


package com.bookshop.pojo;

import java.math.BigDecimal;

public class CartItem {
    private Integer id;
    private String name;
    private Integer count;
    private BigDecimal price;

    private Integer userid;


    public CartItem() {
    }

    public CartItem(Integer id, String name, Integer count, BigDecimal price, Integer userid) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.userid = userid;
    }
    public CartItem(Integer count, BigDecimal price, Integer userid){
        this.count = count;
        this.price = price;
        this.userid = userid;
    }
    public CartItem(Integer  userid){
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", userid=" + userid +
                '}';
    }
}
