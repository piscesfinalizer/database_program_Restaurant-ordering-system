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
import java.io.PrintWriter;

@WebServlet(value = "/UpdateDishServlet")
public class UpdateDishServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String dno = request.getParameter("dno");
        String dname = request.getParameter("dname");
        String dimgpath = request.getParameter("dimgpath");
        float dprice = Float.parseFloat(request.getParameter("dprice"));
        float dweight = Float.parseFloat(request.getParameter("dweight"));
        int dsold = Integer.parseInt(request.getParameter("dsold"));

        Dish dish = new Dish(dno,dname,dimgpath,dprice,dweight,dsold);

        IDishService dishService = new DishServiceImpl();
        boolean result = dishService.updateDishByDno(dno,dish);

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        if(result){
            response.sendRedirect("QueryDishesByPageServlet");
        }else {
            out.println("修改失败!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
