package org.restaurant.servlet;

import org.restaurant.entiey.Box;
import org.restaurant.entiey.Sell;
import org.restaurant.service.IBoxService;
import org.restaurant.service.ISellService;
import org.restaurant.service.impl.BoxServiceImpl;
import org.restaurant.service.impl.SellServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/AddSellServlet")
public class AddSellServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String dates = request.getParameter("dates");
        float turnover = Float.parseFloat(request.getParameter("turnover"));


        Sell sell = new Sell(dates,turnover);
        ISellService sellService = new SellServiceImpl();
        boolean result = sellService.addSell(sell);
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
        request.getRequestDispatcher("QuerySellsByPageServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
