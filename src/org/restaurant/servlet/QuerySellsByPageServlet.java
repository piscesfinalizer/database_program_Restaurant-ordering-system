package org.restaurant.servlet;

import org.restaurant.entiey.Box;
import org.restaurant.entiey.BoxPage;
import org.restaurant.entiey.Sell;
import org.restaurant.entiey.SellPage;
import org.restaurant.service.IBoxService;
import org.restaurant.service.ISellService;
import org.restaurant.service.impl.BoxServiceImpl;
import org.restaurant.service.impl.SellServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/QuerySellsByPageServlet")
public class QuerySellsByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String admin = (String)session.getAttribute("admin");

        if (admin == null){
            response.sendRedirect("login.html");
        }else{
            ISellService sellService = new SellServiceImpl();
            int count = sellService.getTotalCount();

            SellPage sellPage = new SellPage();
            String cPage = request.getParameter("currentPage");//获取当前页码
            if (cPage==null){
                cPage = "1";
            }
            int currentPage = Integer.parseInt(cPage);
            sellPage.setCurrentPage(currentPage);
        /*
            currentPage:当前页（页码）
            students:当前页的数据集合(当前页的所有学生)
         */

            sellPage.setTotalCount(count);

            int pageSize = 8;
            sellPage.setPageSize(pageSize);

            List<Sell> sells = sellService.querySellsByPage(currentPage,pageSize);
            sellPage.setSells(sells);

            request.setAttribute("page",sellPage);
            request.getRequestDispatcher("sells.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
