/**
 * @version 1.0
 */


package com.bookshop.web;


import com.bookshop.pojo.Book;
import com.bookshop.pojo.Cart;
import com.bookshop.pojo.CartItem;
import com.bookshop.pojo.User;
import com.bookshop.service.BookService;
import com.bookshop.service.CartItemService;
import com.bookshop.service.CartService;
import com.bookshop.service.impl.BookSerbviceimpl;
import com.bookshop.service.impl.CartItemSericeimpl;
import com.bookshop.service.impl.CartServiceImpl;
import com.bookshop.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("all")
public class CartServlet extends BaseServlet{
    private BookService bookService = new BookSerbviceimpl();
    private CartItemService cartService = new CartItemSericeimpl();
    private CartService cartcar= new CartServiceImpl();
    private CartItem cartItem = new CartItem();
    private User user = new User();
    private Cart cart = new Cart();


    /**
     * 添加商品项到购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        user = (User) req.getSession().getAttribute("user");
        int userid = user.getId();
        cartItem =new CartItem(book.getId(),book.getName(),1,book.getPrice(),userid);
        CartItem cartid = WebUtils.copyParamToBean(req.getParameterMap(), cartItem);

        req.getSession().setAttribute("lastName",cartid.getName());

       if (cartcar.isExist(userid)){
           cartService.addItem(cartid);
        }else {
            cartService.addItem(cartid);
         }
        Cart count = cartcar.queryCart(userid);
        req.getSession().setAttribute("totalCount",count.getTotalCount());

        resp.sendRedirect(req.getHeader("Referer"));

    }

    /**
     * 删除购物车商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        user = (User) req.getSession().getAttribute("user");
        int userid = user.getId();
        List<CartItem> cartItemsid = cartService.queryCartid(id);
        cartItem= new CartItem(cartItemsid.get(0).getCount(),cartItemsid.get(0).getPrice(),userid);
        cartService.deleteItem(id,cartItem);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clearItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user = (User) req.getSession().getAttribute("user");
        int userid = user.getId();
        cartItem= new CartItem(userid);
        cartService.clear(cartItem);
        resp.sendRedirect(req.getHeader("Referer"));
    }
    /**
     * 修改购物车商品项数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        user = (User) req.getSession().getAttribute("user");
        int userid = user.getId();
        List<CartItem> cartItemsid = cartService.queryCartid(id);
        cartItemsid.get(0).setCount(WebUtils.parseInt(req.getParameter("count"), 1));
        //修改商品价格
        int price = WebUtils.parseInt(req.getParameter("price"), 1);
        cartItem= new CartItem(cartItemsid.get(0).getCount(),cartItemsid.get(0).getPrice(),userid);
        cartService.updateCount(id,cartItem);
        resp.sendRedirect(req.getHeader("Referer"));
    }
    /**
     * 展示购物车商品 信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            user = (User) req.getSession().getAttribute("user");
            int userid = user.getId();
            //获取购物车商品信息
            List<CartItem> cartItems = cartService.queryCart(userid);
            //获取购物车总金额与总数量
            Cart runcar = cartcar.queryCart(userid);
            req.setAttribute("cartItems", cartItems);
            req.setAttribute("runcar", runcar);
            req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req, resp);

    }
    /**
     * 结算购物车商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user = (User) req.getSession().getAttribute("user");
        int userid = user.getId();
        //获取购物车商品信息
        List<CartItem> cartItems = cartService.queryCart(userid);
        //获取购物车总金额与总数量
        Cart runcar = cartcar.queryCart(userid);
        req.setAttribute("cartItems", cartItems);
        req.setAttribute("runcar", runcar);
        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
    }

}
