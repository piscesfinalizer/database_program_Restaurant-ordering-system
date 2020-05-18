<%--
  Created by IntelliJ IDEA.
  User: 10530
  Date: 2020/4/22
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜品管理</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="shortcut icon" type="text/css" href="/imagesrc/披萨.png"/>
    <link type="text/css" rel="stylesheet" href="css/common.css">
</head>
<body>
    <table  class="table table-hover">
        <thead class="thead-dark">
        <tr>
            <th>菜品号</th>
            <th>菜品名</th>
            <th>菜品图片</th>
            <th>菜品价格(元)</th>
            <th>菜品分量(克)</th>
            <th>菜品售出数(份)</th>
            <th>操作</th>
        </tr>
        </thead>
        <c:forEach var="dish" items="${requestScope.page.dishes}">
        <tr>
            <td style="vertical-align: middle !important"><a href="QueryDishByDnoServlet?dno=${dish.dno}">${dish.dno}</a></td>
            <td style="vertical-align: middle !important">${dish.dname}</td>
            <td style="vertical-align: middle !important"><img src="/${dish.dimgpath}" width="200px" height="150px" alt="" title="${dish.dname}" /></td>
            <td style="vertical-align: middle !important">${dish.dprice}</td>
            <td style="vertical-align: middle !important">${dish.dweight}</td>
            <td style="vertical-align: middle !important">${dish.dsold}</td>
            <td style="vertical-align: middle !important"><a href="DeleteDishServlet?dno=${dish.dno}">删除</a> </td>
        </tr>
        </c:forEach>
    </table>

    <div class="fixed-bottom">

        <div class="btn-group">
            <a href="addDish.jsp"><button class="btn btn-info">新增菜品</button></a>
            <a href="main.html"><button type="button" class="btn btn-primary">主菜单</button></a>
        </div>

        <c:choose>
            <c:when test="${requestScope.page.totalPage == 1}"></c:when>
            <c:when test="${requestScope.page.currentPage == requestScope.page.totalPage}">
                <a href="QueryDishesByPageServlet?currentPage=1">首页</a>
                <a href="QueryDishesByPageServlet?currentPage=${requestScope.page.currentPage - 1}">上一页</a>
            </c:when>
            <c:when test="${requestScope.page.currentPage == 1}">
                <a href="QueryDishesByPageServlet?currentPage=${requestScope.page.currentPage + 1}">下一页</a>
                <a href="QueryDishesByPageServlet?currentPage=${requestScope.page.totalPage}">尾页</a>
            </c:when>
            <c:otherwise>
                <a href="QueryDishesByPageServlet?currentPage=1">首页</a>
                <a href="QueryDishesByPageServlet?currentPage=${requestScope.page.currentPage - 1}">上一页</a>
                <a href="QueryDishesByPageServlet?currentPage=${requestScope.page.currentPage + 1}">下一页</a>
                <a href="QueryDishesByPageServlet?currentPage=${requestScope.page.totalPage}">尾页</a>
            </c:otherwise>
        </c:choose>


        <div style="float: right">
            <span>${requestScope.page.currentPage}/${requestScope.page.totalPage}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span>总数据条数:${requestScope.page.totalCount}</span>&nbsp;&nbsp;
        </div>

        <div class="progress">
            <div class="progress-bar bg-success" style="width:${requestScope.page.currentPage*100/requestScope.page.totalPage}%"></div>
        </div>
    </div>

</body>
</html>
