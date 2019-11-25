<%--
  Created by IntelliJ IDEA.
  User: cdx
  Date: 2019/11/21
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  buffer="16kb" %>
<html>
<head>
    <title>登录页面验证</title>
    <script>
        window.onload = function () {

            var im = document.getElementById("img1");
            im.onclick = function () {
                var dt = new Date().getTime();
                im.src = "/day16/checkCodeServlet?time=" + dt;
            }
            var aa = document.getElementById("a1");
            aa.onclick = function () {
                var dt = new Date().getTime();
                im.src = "/day16/checkCodeServlet?time=" + dt;
            }
        }


    </script>
</head>
<body>
<form action="/day16/loginServlet" method="post">
    <div>
        <table align="center" border="1" style="width: 300px;height: 200px" >
            <tr>
                <td>用户名</td>
                <td><input name="username" type="text"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input name="password" type="text"></td>
            </tr>

            <tr>
                <td colspan="2" align="center"><img id="img1" src="/day16/checkCodeServlet"></td>
                <%--               <td><a id="a1" href="">看不清换一张</a></td>--%>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input name="code" type="text"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </div>
    <div>
        <%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%>
    </div>
    <div>
        <%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%>
    </div>
</form>
</body>
</html>
