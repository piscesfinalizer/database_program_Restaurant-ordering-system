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
            <th>菜品名</th>
            <th>菜品图片</th>
            <th>菜品价格(元)</th>
            <th>菜品分量(克)</th>
            <th>份数</th>
            <th>操作</th>
        </tr>
        </thead>
        <c:forEach var="dish" items="${sessionScope.dishes}">
            <tr>
                <td style="vertical-align: middle !important">${dish.dname}</td>
                <td style="vertical-align: middle !important"><img src="/${dish.dimgpath}" width="200px" height="150px" alt="" title="${dish.dname}" /></td>
                <td style="vertical-align: middle !important">${dish.dprice}</td>
                <td style="vertical-align: middle !important">${dish.dweight}</td>
                <td style="vertical-align: middle !important">
                    <a href="ShoppingCarServlet?action=reduce&dno=${dish.dno}"><button class="btn btn-light btn-sm">-</button></a>
                    <span>${dish.num}</span>
                    <a href="ShoppingCarServlet?action=add&dno=${dish.dno}"><button class="btn btn-light btn-sm">+</button></a>
                <td style="vertical-align: middle !important"><a href="ShoppingCarServlet?action=append&dno=${dish.dno}"><button type="button" class="btn btn-primary">添加到购物车</button></a></td>
            </tr>
        </c:forEach>
    </table>
    <div style="display: flex;justify-content: center;align-items: center">
        <a href="ShoppingCarServlet?action=check&dno=1111"><button type="button" class="btn btn-primary">结算</button></a>
    </div>


</body>
</html>
