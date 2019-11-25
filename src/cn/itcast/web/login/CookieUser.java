package cn.itcast.web.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cdx on 2019/11/14.
 * desc:登录demo
 */
@WebServlet("/cookieUser")
public class CookieUser extends HttpServlet {
    private static final String TAG = "CookieDemo4";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        //如何判断是否还有该cookie
        boolean flag = false;
        String username = req.getParameter("msg");

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("lastTime".equals(cookie.getName())) {
                    flag = true;
                    Date date = new Date();
                    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    //String dt = sdf.format(date);

                    resp.getWriter().write(username+"  上次登录时间为:" + URLDecoder.decode(cookie.getValue()));
                    cookie.setValue(URLEncoder.encode(date.toString(),"utf-8"));
                    resp.addCookie(cookie);
                    break;
                }

            }
        }

        if (cookies == null || flag == false) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            //String dt = sdf.format(date);

            Cookie cookie = new Cookie("lastTime", URLEncoder.encode(date.toString(),"utf-8"));
            cookie.setMaxAge(30);
            resp.addCookie(cookie);
            resp.getWriter().write(username+"  感谢第一次登录");

        }

    }
}
