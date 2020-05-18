package org.restaurant.servlet;

import org.restaurant.entiey.Dish;
import org.restaurant.service.IDishService;
import org.restaurant.service.impl.DishServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/QueryDishByDnoServlet")
public class QueryDishByDnoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String dno = request.getParameter("dno");

        IDishService dishService = new DishServiceImpl();
        Dish dish = dishService.queryDishByDno(dno);

        request.setAttribute("dish",dish);
        request.getRequestDispatcher("dishInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
