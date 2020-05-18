package org.restaurant.servlet;

import org.restaurant.entiey.OrdersInProgress;
import org.restaurant.entiey.OrdersInProgressPage;
import org.restaurant.service.IOrdersInProgressService;
import org.restaurant.service.impl.OrdersInProgressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/QueryOrdersInProgressServlet")
public class QueryOrdersInProgressByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String admin = (String)session.getAttribute("admin");

        if (admin == null){
            response.sendRedirect("login.html");
        }else{
            IOrdersInProgressService ordersInProgressService = new OrdersInProgressServiceImpl();
            int count = ordersInProgressService.getTotalCount();
            OrdersInProgressPage ordersInProgressPage = new OrdersInProgressPage();

            String cPage = request.getParameter("currentPage");//获取当前页码
            if (cPage==null){
                cPage = "1";
            }
            int currentPage = Integer.parseInt(cPage);
            ordersInProgressPage.setCurrentPage(currentPage);

            ordersInProgressPage.setTotalCount(count);

            int pageSize = 6;
            ordersInProgressPage.setPageSize(pageSize);

            List<OrdersInProgress> ordersInProgresses = ordersInProgressService.queryOrdersInProgressByPage(currentPage,pageSize);
            ordersInProgressPage.setOrdersInProgresses(ordersInProgresses);

            request.setAttribute("page",ordersInProgressPage);

            request.getRequestDispatcher("ordersInProgress.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
