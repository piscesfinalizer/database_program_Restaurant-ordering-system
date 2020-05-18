<%--
  Created by IntelliJ IDEA.
  User: 10530
  Date: 2020/4/22
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜品详情</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="shortcut icon" type="text/css" href="/imagesrc/披萨.png"/>
    <link type="text/css" rel="stylesheet" href="css/common.css">
</head>
<body>
    <script>
        function check() {
            var dno = $("#dno").val();
            if(!(dno>0 && dno < 100)){
                alert("菜品有误！必须是001-099")
                return false;
            }
            else{
                return true;
            }

        }

    </script>
    <div class="container" >
        <h2>菜品情况</h2>
        <form action="UpdateDishServlet" method="post" onsubmit="return check()">
            <div class="form-group">
                <label for="dno">菜品号:</label>
                <input type="text" class="form-control" name="dno" id="dno" value="${requestScope.dish.dno}"><br/>
            </div>
            <div class="form-group">
                <label for="dname">菜品名:</label>
                <input type="text" class="form-control" name="dname" id="dname" value="${requestScope.dish.dname}"><br/>
            </div>
            <div class="form-group">
                <label for="dimgpath">菜品图片(imagesrc/xxx.jpg):</label>
                <input type="text" class="form-control" name="dimgpath" id="dimgpath" value="${requestScope.dish.dimgpath}"><br/>
            </div>
            <div class="form-group">
                <label for="dprice">菜品价格:</label>
                <input type="text" class="form-control" name="dprice" id="dprice" value="${requestScope.dish.dprice}"><br/>
            </div>
            <div class="form-group">
                <label for="dweight">菜品分量:</label>
                <input type="text" class="form-control" name="dweight" id="dweight" value="${requestScope.dish.dweight}"><br/>
            </div>
            <div class="form-group">
                <label for="dsold">菜品售出数:</label>
                <input type="text" class="form-control" name="dsold" id="dsold" value="${requestScope.dish.dsold}"><br/>
            </div>
            <input type="submit" class="btn btn-primary" value="修改菜品信息">
            <button class="btn btn-info"><a href="QueryDishesByPageServlet">返回</a></button>
        </form>
    </div>
</body>
</html>
