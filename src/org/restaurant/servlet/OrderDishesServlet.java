package org.restaurant.servlet;

import org.restaurant.entiey.Dish;
import org.restaurant.entiey.DishPage;
import org.restaurant.service.IDishService;
import org.restaurant.service.impl.DishServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/OrderDishesServlet")
public class OrderDishesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<Dish> dishes = (List<Dish>)session.getAttribute("dishes");

        if (dishes == null){
            IDishService dishService = new DishServiceImpl();

            dishes = dishService.queryAllDishes();
        }


        session.setAttribute("dishes",dishes);
        response.sendRedirect("order.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
