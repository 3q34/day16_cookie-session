<%--
  Created by IntelliJ IDEA.
  User: cdx
  Date: 2019/11/7
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    Cookie cookie = new Cookie("msg", "haha");

%>
<%!
    int i = 3;

%><br>
<%=  i
%>
<h1> hahh </h1>
<br>
<% String path = request.getContextPath();
    response.getWriter().write(path+"  response");
    out.print(path+"   out");
%>
</body>
</html>
