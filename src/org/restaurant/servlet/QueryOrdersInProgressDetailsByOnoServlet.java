package org.restaurant.servlet;

import org.restaurant.entiey.OrderDetail;
import org.restaurant.service.IOrdersDetailsService;
import org.restaurant.service.impl.OrdersDetailsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/QueryOrdersInProgressDetailsByOnoServlet")
public class QueryOrdersInProgressDetailsByOnoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String ono = request.getParameter("ono");

        IOrdersDetailsService ordersDetailsService = new OrdersDetailsServiceImpl();
        List<OrderDetail> orderDetails = ordersDetailsService.queryOrderDetailsByOno(ono,1);

        request.setAttribute("orderDetails",orderDetails);
        request.getRequestDispatcher("ordersInProgressDetails.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request, response);
    }
}
