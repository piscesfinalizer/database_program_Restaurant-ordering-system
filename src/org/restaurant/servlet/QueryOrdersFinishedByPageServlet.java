package org.restaurant.servlet;

import org.restaurant.entiey.OrdersFinished;
import org.restaurant.entiey.OrdersFinishedPage;
import org.restaurant.service.IOrdersFinishedService;
import org.restaurant.service.impl.OrdersFinishedServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/QueryOrdersFinishedByPageServlet")
public class QueryOrdersFinishedByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String admin = (String)session.getAttribute("admin");

        if (admin == null){
            response.sendRedirect("login.html");
        }else{
            IOrdersFinishedService ordersFinishedService = new OrdersFinishedServiceImpl();
            int count = ordersFinishedService.getTotalCount();

            OrdersFinishedPage ordersFinishedPage = new OrdersFinishedPage();
            ordersFinishedPage.setTotalCount(count);

            String cPage = request.getParameter("currentPage");//获取当前页码
            if (cPage==null){
                cPage = "1";
            }
            int currentPage = Integer.parseInt(cPage);
            ordersFinishedPage.setCurrentPage(currentPage);

            int pageSize = 6;
            ordersFinishedPage.setPageSize(pageSize);

            List<OrdersFinished> ordersFinisheds = ordersFinishedService.queryOrdersFinishedByPage(currentPage,pageSize);
            ordersFinishedPage.setOrdersFinisheds(ordersFinisheds);

            request.setAttribute("page",ordersFinishedPage);
            request.getRequestDispatcher("ordersFinished.jsp").forward(request,response);


        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
