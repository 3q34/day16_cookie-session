package cn.itcast.web.cookie;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cdx on 2019/11/7.
 * desc:
 */
@WebServlet("/cookieDemo1")
public class CookieDemo1 extends HttpServlet {
    private static final String TAG = "CookieDemo1";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Cookie cookie=new Cookie("username","陈东晓");
        Cookie cookie1=new Cookie("psw","123456");
       resp.addCookie(cookie);
        resp.addCookie(cookie1);
    }
}
