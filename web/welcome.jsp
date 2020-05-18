<%--
  Created by IntelliJ IDEA.
  User: 10530
  Date: 2020/4/28
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎来到点餐系统</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="shortcut icon" type="text/css" href="/imagesrc/汉堡.png"/>
    <style>
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
            width: 450px;
            height: 250px;
            max-width: 800px;
            max-height: 600px;
            box-shadow: 0px 0px 100px black;
            position: absolute;
            border-radius: 5px;
            overflow: hidden;
        }
        #form{
            opacity: 60%;
            background-color: snow;
            width: 100%;
            height: 100%;

        }
        #title{
            width: 100%;
            height: 10%;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        #title span{
            font-family:"幼圆";
            font-size: larger;
        }
        #mainBox{
            margin-top: 10px;
            width: 100%;
            height: 70%;
            display: flex;
            justify-content: space-around;
            align-items: center;
        }
        hr{
            width:80%;
            margin:0 auto;
            border: 0;
            height: 1px;
            background-image: linear-gradient(to right, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0));
        }
        input[type='text']{
            width: 60%;
            height: 20%;
            font-size: larger;
            font-family: "幼圆";
        }
        #bottomBox{
            width: 100%;
            display: flex;
            justify-content: center;
        }
        #admin{
            position: absolute;
            bottom: 10px;
            right: 10px;
        }
    </style>
</head>
<body>
    <div id="box">
        <div id="app">
            <form id="form" action="WelcomeServlet" method="POST">
                <div id="title">
                    <span>请填写用餐人数</span>
                </div>
                <hr/>
                <div id="mainBox">
                    <input name="diners" type="text" list="list" placeholder="请填写用餐人数" required>
                    <datalist id="list">
                        <option value="2"></option>
                        <option value="3"></option>
                        <option value="4"></option>
                        <option value="5"></option>
                        <option value="6"></option>
                        <option value="7"></option>
                        <option value="8"></option>
                        <option value="9"></option>
                        <option value="10"></option>
                        <option value="11"></option>
                        <option value="12"></option>
                        <option value="13"></option>
                        <option value="14"></option>
                        <option value="15"></option>
                        <option value="16"></option>
                        <option value="17"></option>
                        <option value="18"></option>
                        <option value="19"></option>
                        <option value="20"></option>
                    </datalist>
                </div>
                <div id="bottomBox">
                    <input class="btn btn-primary" type="submit" value="开始点餐">
                </div>
            </form>
        </div>
        <div id="admin">
            <a href="login.html"><button class="btn btn-outline-secondary">管理员入口</button></a>
        </div>
    </div>
</body>
</html>
