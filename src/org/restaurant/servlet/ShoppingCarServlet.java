package org.restaurant.servlet;

import org.restaurant.entiey.Dish;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/ShoppingCarServlet")
public class ShoppingCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String dno = null;

        String action = request.getParameter("action");
        List<Dish> dishes = (List<Dish>)session.getAttribute("dishes");

        List<Dish> shoppingCar = (List<Dish>)session.getAttribute("shoppingCar");

        if (shoppingCar == null){
            shoppingCar = new ArrayList<>();
        }

        switch (action){
            case "add":
                dno = request.getParameter("dno").trim();
                for(Dish dish : dishes){
                    if (dish.getDno().equals(dno)){
                        dish.addNum();
                    }

                }
                session.setAttribute("dishes",dishes);
                request.getRequestDispatcher("OrderDishesServlet").forward(request,response);
                break;

            case "reduce":
                dno = request.getParameter("dno").trim();
                for(Dish dish : dishes){
                    if (dish.getDno().equals(dno))
                        dish.reduceNum();
                }
                session.setAttribute("dishes",dishes);
                request.getRequestDispatcher("OrderDishesServlet").forward(request,response);
                break;
            case "append":
                dno = request.getParameter("dno").trim();
                for(Dish dish : dishes){
                    if (dish.getDno().equals(dno))
                        shoppingCar.add(dish);
                }
                session.setAttribute("shoppingCar",shoppingCar);
                System.out.println(shoppingCar.size());
                request.getRequestDispatcher("OrderDishesServlet").forward(request,response);
                break;

            case "check":
                response.sendRedirect("shoppingCar.jsp");
                break;

            case "remove":
                dno = request.getParameter("dno").trim();
                for(Dish dish : dishes){
                    if (dish.getDno().equals(dno))
                        shoppingCar.remove(dish);
                }
                session.setAttribute("shoppingCar",shoppingCar);
                response.sendRedirect("shoppingCar.jsp");
                break;
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
