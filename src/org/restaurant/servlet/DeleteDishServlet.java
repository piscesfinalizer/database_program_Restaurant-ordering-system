package org.restaurant.servlet;

import org.restaurant.service.IDishService;
import org.restaurant.service.impl.DishServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/DeleteDishServlet")
public class DeleteDishServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String dno = request.getParameter("dno");
        IDishService dishService = new DishServiceImpl();

        boolean result = dishService.deleteDishByDno(dno);

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        if(result){
            response.sendRedirect("QueryDishesByPageServlet");
        }else {
            out.println("删除失败！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
