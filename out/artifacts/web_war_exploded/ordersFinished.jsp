<%--
  Created by IntelliJ IDEA.
  User: 10530
  Date: 2020/4/30
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>历史消费记录</title>
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
            <th>消费单号</th>
            <th>包厢号</th>
            <th>花销</th>
            <th>联系电话</th>
            <th>支付方式</th>
            <th>结账时间</th>
        </tr>
        </thead>
        <c:forEach var="ordersFinished" items="${requestScope.page.ordersFinisheds}">
            <tr>
                <td style="vertical-align: middle !important"><a href="QueryOrdersFinishedDetailsByOnoServlet?ono=${ordersFinished.ono}">${ordersFinished.ono}</a></td>
                <td style="vertical-align: middle !important">${ordersFinished.bno}</td>
                <td style="vertical-align: middle !important">${ordersFinished.cost}</td>
                <td style="vertical-align: middle !important">${ordersFinished.cphone}</td>
                <td style="vertical-align: middle !important">${ordersFinished.payway}</td>
                <td style="vertical-align: middle !important">${ordersFinished.checktime}</td>
            </tr>
        </c:forEach>
    </table>

    <div class="fixed-bottom">
        <div class="btn-group">
            <a href="main.html"><button type="button" class="btn btn-primary">主菜单</button></a>
        </div>
        <c:choose>
            <c:when test="${requestScope.page.totalPage == 1}"></c:when>
            <c:when test="${requestScope.page.currentPage == 1}">
            <a href="QueryOrdersFinishedByPageServlet?currentPage=${requestScope.page.currentPage + 1}">下一页</a>
            <a href="QueryOrdersFinishedByPageServlet?currentPage=${requestScope.page.totalPage}">尾页</a>
            </c:when>
            <c:when test="${requestScope.page.currentPage == requestScope.page.totalPage}">
                <a href="QueryOrdersFinishedByPageServlet?currentPage=1">首页</a>
                <a href="QueryOrdersFinishedByPageServlet?currentPage=${requestScope.page.currentPage - 1}">上一页</a>
            </c:when>

            <c:otherwise>
                <a href="QueryOrdersFinishedByPageServlet?currentPage=1">首页</a>
                <a href="QueryOrdersFinishedByPageServlet?currentPage=${requestScope.page.currentPage - 1}">上一页</a>
                <a href="QueryOrdersFinishedByPageServlet?currentPage=${requestScope.page.currentPage + 1}">下一页</a>
                <a href="QueryOrdersFinishedByPageServlet?currentPage=${requestScope.page.totalPage}">尾页</a>
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
