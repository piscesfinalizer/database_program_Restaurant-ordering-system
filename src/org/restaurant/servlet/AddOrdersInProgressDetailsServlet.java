package org.restaurant.servlet;

import org.restaurant.entiey.Dish;
import org.restaurant.entiey.OrderDetail;
import org.restaurant.entiey.OrdersInProgress;
import org.restaurant.service.IOrdersDetailsService;
import org.restaurant.service.impl.OrdersDetailsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/AddOrdersInProgressDetailsServlet")
public class AddOrdersInProgressDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        List<Dish> shoppingCar = (List<Dish>)session.getAttribute("shoppingCar");
        OrdersInProgress ordersInProgress = (OrdersInProgress)session.getAttribute("currentOrder");
        IOrdersDetailsService ordersDetailsService = new OrdersDetailsServiceImpl();

        System.out.println(ordersInProgress.toString());

        String ono = ordersInProgress.getOno();

        System.out.println(ono);
        for(Dish dish : shoppingCar){
            System.out.println(dish.toString());
            ordersDetailsService.addOrderDetail(new OrderDetail(ono,dish.getDno(),dish.getDprice(),dish.getNum()),1);
        }

        response.sendRedirect("haveMeal.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
