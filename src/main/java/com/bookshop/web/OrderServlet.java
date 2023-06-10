package com.bookshop.web;

import com.bookshop.pojo.Order;
import com.bookshop.pojo.User;
import com.bookshop.service.OrderService;
import com.bookshop.service.impl.OrderServiceImpl;
import com.bookshop.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Random;


public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();
    private static int orderCount = 0;

    /**
     * 生成订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        User loginUser = (User) req.getSession().getAttribute("user");

        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }


        int userId = loginUser.getId();
        String orderNumber = generateOrderNumber();
        int orderNumberInt = Integer.parseInt(orderNumber);

        Order order = new Order(orderNumberInt, userId);
        orderService.saveOrder(order);
        req.getSession().setAttribute("orderNumberInt", orderNumberInt);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

    /**
     * 查看所有订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.queryOrder();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/pages/manager/order.jsp").forward(req, resp);
    }
    /**
     * 查看所有订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void deleteOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        orderService.deleteOrder(i);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/cart.jsp");
    }

    public static synchronized String generateOrderNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }

        return sb.toString();
    }



}
