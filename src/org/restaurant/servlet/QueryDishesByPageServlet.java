package org.restaurant.servlet;

import org.restaurant.entiey.Dish;
import org.restaurant.entiey.DishPage;
import org.restaurant.entiey.Sell;
import org.restaurant.entiey.SellPage;
import org.restaurant.service.IDishService;
import org.restaurant.service.ISellService;
import org.restaurant.service.impl.DishServiceImpl;
import org.restaurant.service.impl.SellServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/QueryDishesByPageServlet")
public class QueryDishesByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String admin = (String)session.getAttribute("admin");

        if (admin == null){
            response.sendRedirect("login.html");
        }else {
            IDishService dishService = new DishServiceImpl();
            int count = dishService.getTotalCount();

            DishPage dishPage = new DishPage();
            String cPage = request.getParameter("currentPage");//获取当前页码
            if (cPage==null){
                cPage = "1";
            }
            int currentPage = Integer.parseInt(cPage);
            dishPage.setCurrentPage(currentPage);
        /*
            currentPage:当前页（页码）
            students:当前页的数据集合(当前页的所有学生)
         */

            dishPage.setTotalCount(count);

            int pageSize = 3;
            dishPage.setPageSize(pageSize);

            List<Dish> dishes = dishService.queryDishesByPage(currentPage,pageSize);
            dishPage.setDishes(dishes);

            request.setAttribute("page",dishPage);
            request.getRequestDispatcher("dishes.jsp").forward(request,response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
