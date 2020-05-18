<%--
  Created by IntelliJ IDEA.
  User: 10530
  Date: 2020/4/22
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加包厢</title>
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
            <div class="container">
                <h2>添加包厢</h2>
                <form action="AddBoxServlet" method="post" onsubmit="return check()">
                    <div class="form-group">
                        <label for="bno">包厢号:</label>
                        <input type="text" class="form-control" name="bno" id="bno"><br/>
                    </div>
                    <div class="form-group">
                        <label for="bname">包厢名:</label>
                        <input type="text" class="form-control" name="bname" id="bname"><br/>
                    </div>
                    <div class="form-group">
                        <label for="bcapacity">包厢容量:</label>
                        <input type="text" class="form-control" name="bcapacity" id="bcapacity"><br/>
                    </div>
                    <div class="form-group">
                        <label for="bstate">包厢状态:</label>
                        <input type="text" class="form-control" name="bstate" id="bstate" value="空闲" readonly="readonly"><br/>
                    </div>
                    <input type="submit" class="btn btn-primary" value="新增包厢">
                    <button class="btn btn-info"><a href="QueryBoxesByPageServlet">返回</a></button>
                </form>
            </div>
        </div>
    </div>
    <script>
        function check() {
            var sno = $("#bno").val();
            var sname = $("#bname").val();
            if(!(sno>0 && sno < 100)){
                alert("学号有误！必须是1-99")
                return false;
            }
            if(!(sname.length == 3)){
                alert("姓名格式有误！长度为3")
                return false;
            }else{
                return true;
            }

        }

    </script>

</body>
</html>
