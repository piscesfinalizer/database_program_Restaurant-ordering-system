<%--
  Created by IntelliJ IDEA.
  User: 10530
  Date: 2020/4/22
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加营业记录</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="shortcut icon" type="text/css" href="/imagesrc/银行.png"/>
    <link type="text/css" rel="stylesheet" href="css/common.css">

</head>
<body>
    <div id="box">
        <div id="app">
            <div class="container">
                <h2>添加营业记录</h2>
                <form action="AddSellServlet" method="post">
                    <div class="form-group">
                        <label for="dates">日期(格式:2020-04-22):</label>
                        <input type="text" class="form-control" name="dates" id="dates"><br/>
                    </div>
                    <div class="form-group">
                        <label for="turnover">营业额:</label>
                        <input type="text" class="form-control" name="turnover" id="turnover"><br/>
                    </div>
                    <input type="submit" class="btn btn-primary" value="新增营业情况">
                    <button class="btn btn-info"><a href="QuerySellsByPageServlet">返回</a></button>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
