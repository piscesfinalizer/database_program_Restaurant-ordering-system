<%--
  Created by IntelliJ IDEA.
  User: 10530
  Date: 2020/4/29
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>购物车</title>
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
            <th>菜品单价</th>
            <th>份数</th>
            <th>价格</th>
            <th>操作</th>
        </tr>
        </thead>
        <c:forEach var="dish" items="${sessionScope.shoppingCar}">
            <tr>
                <td style="vertical-align: middle !important">${dish.dname}</td>
                <td style="vertical-align: middle !important">${dish.dprice}</td>
                <td style="vertical-align: middle !important">
                    <span>${dish.num}</span>
                </td>
                <td>${dish.num*dish.dprice}</td>
                <td style="vertical-align: middle !important"><a href="ShoppingCarServlet?action=remove&dno=${dish.dno}"><button type="button" class="btn btn-primary">移除</button></a></td>
            </tr>
        </c:forEach>
    </table>
    <div style="display: flex;justify-content: space-around;align-items: center">
        <a href="order.jsp"><button type="button" class="btn btn-primary">继续点餐</button></a>
        <a href="AddOrdersInProgressDetailsServlet"><button type="button" class="btn btn-primary">确定</button></a>
    </div>

</body>
</html>
