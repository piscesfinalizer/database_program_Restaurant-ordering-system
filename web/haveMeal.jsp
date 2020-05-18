<%--
  Created by IntelliJ IDEA.
  User: 10530
  Date: 2020/4/29
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请您用餐</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>
        /* Make the image fully responsive */
        *{
            margin: 0px;
            padding: 0px;
        }
        body{
            position: absolute;
            top: 0px;
            bottom: 0px;
            left: 0px;
            right: 0px;
            overflow: hidden;
        }
        #box{
            display: flex;
            width: 100%;
            height: 100%;
            background-repeat: no-repeat;
            background-size: cover;
            background-position: center;
            background-image: url("/imagesrc/background.jpg");
            justify-content: center;
            align-items: center;
        }
        #app{
            width: 800px;
            height: 600px;
            max-width: 800px;
            max-height: 600px;
            box-shadow: 0px 0px 100px black;
            position: absolute;
            border-radius: 5px;
            overflow: hidden;
        }
        .carousel-inner img {
            width: 100%;
            height: 100%;
        }
        #demo{
            width: 100%;
            height: 70%;
        }
        #footer{
            height: 30%;


        }
    </style>
</head>
<body>
    <div id="box">
        <div id="app">
            <div id="demo" class="carousel slide" data-ride="carousel">

                <!-- 指示符 -->
                <ul class="carousel-indicators">
                    <li data-target="#demo" data-slide-to="0" class="active"></li>
                    <li data-target="#demo" data-slide-to="1"></li>
                    <li data-target="#demo" data-slide-to="2"></li>
                </ul>

                <!-- 轮播图片 -->
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="/imagesrc/xiaochaorou.jpg">
                    </div>
                    <div class="carousel-item">
                        <img src="/imagesrc/shuizhuroupian.jpg">
                    </div>
                    <div class="carousel-item">
                        <img src="/imagesrc/niupai.jpg">
                    </div>
                </div>

                <!-- 左右切换按钮 -->
                <a class="carousel-control-prev" href="#demo" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#demo" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>

            </div>
            <div id="footer">
                <a href="check.html"><button style="width: 100%;height: 100%" class="mx-auto btn btn-primary btn-lg btn-block" style="width:150px">付款</button></a>
            </div>

        </div>
    </div>



</body>
</html>
