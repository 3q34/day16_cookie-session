package cn.itcast.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cdx on 2019/11/14.
 * desc:Cookie的设置
 * cookie的特点：存储少量的数据
 * 在不登陆的情况下完成身份的识别
 */
@WebServlet("/cookieDemo3")
public class CookieDemo3 extends HttpServlet {
    private static final String TAG = "CookieDemo3";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("uesrname", "admin");
        //设置cookie持久化到硬盘，正数，时间30秒
        cookie.setMaxAge(30);
        //0为删除cookie
        //cookie.setMaxAge(0);

        //可以在不用项目中共享cookie
        cookie.setPath("/");
        //不同的tomcat项目中也可以共享

        // cookie.setDomain(".baidu.com");
        // 那么。tieba.baidu.com 和news.baidu.com可以共享Cookie
        resp.addCookie(cookie);
        //浏览器对cookie的大小限制4K以下
    }
}
