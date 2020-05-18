<%--
  Created by IntelliJ IDEA.
  User: 10530
  Date: 2020/4/21
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>包厢情况</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="shortcut icon" type="text/css" href="/imagesrc/办公.png"/>
    <link type="text/css" rel="stylesheet" href="css/common.css">


</head>
<body>
    <div id="box">
        <div id="app">
            <div id="mainBox">
                <table  class="table table-hover">
                    <thead class="thead-dark">
                    <tr>
                        <th>包厢号</th>
                        <th>包厢名</th>
                        <th>包厢容量</th>
                        <th>包厢状态</th>
                    </tr>
                    </thead>
                    <c:forEach var="box" items="${requestScope.page.boxes}">
                        <tr>
                            <td>${box.bno}<a/></td>
                            <td>${box.bname}</td>
                            <td>${box.bcapacity}</td>
                            <td>${box.bstate}</td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
            <div id="footer" class="fixed-bottom">

                <div class="btn-group">
                    <a href="addBox.jsp"><button type="button" class="btn btn-info">新增包厢</button></a>
                    <a href="main.html"><button type="button" class="btn btn-primary">主菜单</button></a>
                </div>

                <c:choose>
                    <c:when test="${requestScope.page.totalPage == 1}"></c:when>
                    <c:when test="${requestScope.page.currentPage == requestScope.page.totalPage}">
                        <a href="QueryBoxesByPageServlet?currentPage=1">首页</a>
                        <a href="QueryBoxesByPageServlet?currentPage=${requestScope.page.currentPage - 1}">上一页</a>
                    </c:when>
                    <c:when test="${requestScope.page.currentPage == 1}">
                        <a href="QueryBoxesByPageServlet?currentPage=${requestScope.page.currentPage + 1}">下一页</a>
                        <a href="QueryBoxesByPageServlet?currentPage=${requestScope.page.totalPage}">尾页</a>
                    </c:when>
                    <c:otherwise>
                        <a href="QueryBoxesByPageServlet?currentPage=1">首页</a>
                        <a href="QueryBoxesByPageServlet?currentPage=${requestScope.page.currentPage - 1}">上一页</a>
                        <a href="QueryBoxesByPageServlet?currentPage=${requestScope.page.currentPage + 1}">下一页</a>
                        <a href="QueryBoxesByPageServlet?currentPage=${requestScope.page.totalPage}">尾页</a>
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
        </div>
    </div>




</body>
</html>
