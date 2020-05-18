package org.restaurant.servlet;

import org.restaurant.entiey.Box;
import org.restaurant.entiey.OrdersInProgress;
import org.restaurant.service.IBoxService;
import org.restaurant.service.IOrdersFinishedService;
import org.restaurant.service.IOrdersInProgressService;
import org.restaurant.service.impl.BoxServiceImpl;
import org.restaurant.service.impl.OrdersFinishedServiceImpl;
import org.restaurant.service.impl.OrdersInProgressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int diners = Integer.parseInt(request.getParameter("diners"));
        IBoxService boxService = new BoxServiceImpl();
        Box box = boxService.queryAppropriateBoxes(diners);
        IOrdersInProgressService ordersInProgressService = new OrdersInProgressServiceImpl();
        IOrdersFinishedService ordersFinishedService = new OrdersFinishedServiceImpl();



        int newOno = ordersFinishedService.getTotalCount()+ordersInProgressService.getTotalCount()+3;
        if (box == null){
            response.sendRedirect("welcome.jsp");
        }else {
            String ono =String.format("%08d",newOno);
            OrdersInProgress ordersInProgress = new OrdersInProgress(ono,box.getBno(),0,diners);
            ordersInProgressService.addOrdersInProgress(ordersInProgress);
            HttpSession session = request.getSession();

            session.setAttribute("currentOrder",ordersInProgress);
            request.getRequestDispatcher("OrderDishesServlet").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
