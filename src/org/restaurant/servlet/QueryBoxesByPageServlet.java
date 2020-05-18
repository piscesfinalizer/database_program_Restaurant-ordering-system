package org.restaurant.servlet;

import org.restaurant.entiey.Box;
import org.restaurant.entiey.BoxPage;
import org.restaurant.service.IBoxService;
import org.restaurant.service.impl.BoxServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/QueryBoxesByPageServlet")
public class QueryBoxesByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String admin = (String)session.getAttribute("admin");

        if (admin == null){
            response.sendRedirect("login.html");
        }else {
            IBoxService boxService = new BoxServiceImpl();
            int count = boxService.getTotalCount();

            BoxPage boxPage = new BoxPage();
            String cPage = request.getParameter("currentPage");//获取当前页码
            if (cPage==null){
                cPage = "1";
            }
            int currentPage = Integer.parseInt(cPage);
            boxPage.setCurrentPage(currentPage);
        /*
            currentPage:当前页（页码）
            students:当前页的数据集合(当前页的所有学生)
         */

            boxPage.setTotalCount(count);

            int pageSize = 8;
            boxPage.setPageSize(pageSize);

            List<Box> boxs = boxService.queryBoxesByPage(currentPage,pageSize);
            boxPage.setBoxes(boxs);

            request.setAttribute("page",boxPage);
            request.getRequestDispatcher("boxes.jsp").forward(request,response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
