<%--
  Created by IntelliJ IDEA.
  User: 10530
  Date: 2020/4/30
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详情</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="shortcut icon" type="text/css" href="/imagesrc/订单.png"/>
    <link type="text/css" rel="stylesheet" href="css/common.css">
</head>
<body>
    <table  class="table table-hover">
        <thead class="thead-dark">
        <tr>
            <th>消费单号</th>
            <th>菜品号</th>
            <th>菜品单价</th>
            <th>菜品数量</th>
        </tr>
        </thead>
        <c:forEach var="orderDetail" items="${requestScope.orderDetails}">
            <tr>
                <td style="vertical-align: middle !important">${orderDetail.ono}</td>
                <td style="vertical-align: middle !important">${orderDetail.dno}</td>
                <td style="vertical-align: middle !important">${orderDetail.dprice}</td>
                <td style="vertical-align: middle !important">${orderDetail.damount}</td>
            </tr>
        </c:forEach>
    </table>
    <div class="fixed-bottom">
        <div class="btn-group">
            <a href="main.html"><button type="button" class="btn btn-primary">主菜单</button></a>
        </div>
    </div>
</body>
</html>
