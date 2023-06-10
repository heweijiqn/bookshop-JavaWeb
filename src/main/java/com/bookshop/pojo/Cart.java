/**
 * @version 1.0
 */


package com.bookshop.pojo;



@SuppressWarnings("all")
public class Cart {
    private Integer totalCount;
    private Integer totalPrice;

    private Integer userid;


    public Cart() {
    }

    public Cart(Integer totalCount, Integer totalPrice, Integer userid) {
        this.totalCount = totalCount;
        this.totalPrice = totalPrice;
        this.userid = userid;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + totalCount +
                ", totalPrice=" + totalPrice +
                ", userid=" + userid +
                '}';
    }
}
