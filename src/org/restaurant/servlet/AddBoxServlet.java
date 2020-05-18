package org.restaurant.servlet;

import org.restaurant.entiey.Box;
import org.restaurant.service.IBoxService;
import org.restaurant.service.impl.BoxServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/AddBoxServlet")
public class AddBoxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String bno = request.getParameter("bno");
        String bname = request.getParameter("bname");
        int bcapacity = Integer.parseInt(request.getParameter("bcapacity"));
        String bstate = request.getParameter("bstate");

        Box box = new Box(bno,bname,bcapacity,bstate);
        IBoxService boxService = new BoxServiceImpl();
        boolean result = boxService.addBox(box);
        /*
            JSP:out request response session application

            servlet中
            out : PrintWriter out = response.getWriter();
            session:request.getSession()
            application:request.getServletContext()
         */


        if(!result){//如果增加失败，给request放入一条数据 “error”
            request.setAttribute("error","addError");
        }else {
            request.setAttribute("error","noAddError");
        }
        request.getRequestDispatcher("QueryBoxesByPageServlet").forward(request,response);
        //response.sendRedirect("QueryAllStudentsServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
