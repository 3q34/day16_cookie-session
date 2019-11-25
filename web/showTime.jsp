<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示最后登录时间</title>
</head>
<body>
<%

    //如何判断是否还有该cookie
    boolean flag = false;

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("lastTime".equals(cookie.getName())) {
                flag = true;
                Date date = new Date();
                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                //String dt = sdf.format(date);

%>

上次登录时间为: <%=URLDecoder.decode(cookie.getValue())%>
<% cookie.setValue(URLEncoder.encode(date.toString(), "utf-8"));
    response.addCookie(cookie);
    break;
}

}
}

    if (cookies == null || flag == false) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        //String dt = sdf.format(date);

        Cookie cookie = new Cookie("lastTime", URLEncoder.encode(date.toString(), "utf-8"));
        cookie.setMaxAge(30);
        response.addCookie(cookie);
%>
out.write("感谢第一次登录");
<%


    }
%>
</body>
</html>
