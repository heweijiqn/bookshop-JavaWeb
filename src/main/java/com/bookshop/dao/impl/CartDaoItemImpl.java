/**
 * @version 1.0
 */


package com.bookshop.dao.impl;

import com.bookshop.dao.CartItemDao;
import com.bookshop.pojo.Cart;
import com.bookshop.pojo.CartItem;

import java.math.BigDecimal;
import java.util.List;


@SuppressWarnings("all")
public class CartDaoItemImpl extends BasicDAO<CartItem>  implements CartItemDao {
    private CartItem cartItem = new CartItem();
    private Cart cart = new Cart();


    @Override
    public void addItem(CartItem cartItem) {

        String select = "select * from t_cart_item where id = ? ";
        CartItem cart = querySingle(select, CartItem.class, cartItem.getId());
        if (cart == null){
            String add = "insert into t_cart_item(`id`,`name`,`count`,`price`,`userid`) values(?,?,?,?,?)";
            update(add,cartItem.getId(),cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getUserid());
        }else {
           //如果存在该商品，就修改商品数量
            String update = "update t_cart_item set count = count + 1 where id = ?";
            update(update,cartItem.getId());
        }
        String updateCart = "update t_cart set totalPrice = totalPrice + ?,totalCount = totalCount + 1 where userid = ?";
        update(updateCart,cartItem.getPrice(),cartItem.getUserid());




    }

    @Override
    public void deleteItem(Integer id,CartItem cartItem) {
        String sql = "delete from t_cart_item where id = ?";
        update(sql,id);
        String update = "update t_cart set totalcount = totalcount - ?,totalprice = totalprice - ? where userid = ?";
        BigDecimal price = cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount()));
        update(update,cartItem.getCount(),price,cartItem.getUserid());

    }

    @Override
    public void clear(CartItem cartItem) {
        String sql = "delete from t_cart_item where userid = ?";
        update(sql,cartItem.getUserid());
        String update = "delete from t_cart where userid = ?";
        update(update,cartItem.getUserid());

    }

    @Override
    public void updateCount(Integer id, CartItem cartItem) {
        //获取原来的数量及价格
        String sql ="select count,price from t_cart_item where id = ?";
        CartItem cart = querySingle(sql, CartItem.class, id);

        Integer num = cart.getCount();

        //原来的价格
        BigDecimal price = cart.getPrice();
        BigDecimal total = price.multiply(new BigDecimal(num));

        //修改数量及价格
        String update = "update t_cart_item set count = ? where id = ?";
        Integer count = cartItem.getCount();
        update(update,cartItem.getCount(),id);

        //计算修改后的价格
        BigDecimal newPrice = price.multiply(new BigDecimal(count));

        String add = "update t_cart set totalcount = totalcount - ? + ?,totalprice = totalprice - ? + ? where userid = ?";
        update(add,num,count,total,newPrice,cartItem.getUserid());

    }

    @Override
    public List<CartItem> queryCart(Integer userid) {
        String sql = "select * from t_cart_item where userid = ?";
        List<CartItem> cartItems =  queryMulti(sql, CartItem.class, userid);
        return cartItems;
    }

    @Override
    public List<CartItem> queryCartid(Integer id) {
        String sql = "select * from t_cart_item where id = ?";
        List<CartItem> cartItems =  queryMulti(sql, CartItem.class, id);
        return cartItems;
    }


}
