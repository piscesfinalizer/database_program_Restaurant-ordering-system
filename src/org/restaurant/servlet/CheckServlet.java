package org.restaurant.servlet;

import org.restaurant.entiey.Dish;
import org.restaurant.entiey.OrderDetail;
import org.restaurant.entiey.OrdersFinished;
import org.restaurant.entiey.OrdersInProgress;
import org.restaurant.service.IOrdersDetailsService;
import org.restaurant.service.IOrdersFinishedService;
import org.restaurant.service.IOrdersInProgressService;
import org.restaurant.service.impl.OrdersDetailsServiceImpl;
import org.restaurant.service.impl.OrdersFinishedServiceImpl;
import org.restaurant.service.impl.OrdersInProgressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@WebServlet(value = "/CheckServlet")
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String cphone = request.getParameter("cphone");
        String payway = request.getParameter("payway");

        HttpSession session = request.getSession();
        List<Dish> shoppingCar = (List<Dish>)session.getAttribute("shoppingCar");
        OrdersInProgress ordersInProgress = (OrdersInProgress)session.getAttribute("currentOrder");


        IOrdersInProgressService ordersInProgressService = new OrdersInProgressServiceImpl();
        IOrdersFinishedService ordersFinishedService = new OrdersFinishedServiceImpl();
        IOrdersDetailsService ordersDetailsService = new OrdersDetailsServiceImpl();

        ordersInProgressService.deleteOrdersInProgressByOno(ordersInProgress.getOno());

        String ono = ordersInProgress.getOno();
        String bno = ordersInProgress.getBno();

        Timestamp checktime = new Timestamp(new Date().getTime());

        ordersFinishedService.addOrdersFinished(new OrdersFinished(ono,bno,0,cphone,payway,checktime));
        for(Dish dish : shoppingCar){
            ordersDetailsService.addOrderDetail(new OrderDetail(ono,dish.getDno(),dish.getDprice(),dish.getNum()),2);
        }
        session.removeAttribute("currentOrder");
        session.removeAttribute("shoppingCar");

        response.sendRedirect("welcome.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
