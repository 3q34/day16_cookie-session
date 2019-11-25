package cn.itcast.web.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by cdx on 2019/11/21.
 * desc:
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final String TAG = "LoginServlet";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        String sessioncode = session.getAttribute("code").toString();
        session.removeAttribute("code");
        String code1 = req.getParameter("code");

        if (sessioncode != null && sessioncode.equalsIgnoreCase(code1)) {

            String name = req.getParameter("username");
            String psw = req.getParameter("password");

            User loginUser = new User(name, psw);

            UserDao dao = new UserDao();
            int count = dao.login(loginUser);
            System.out.println(count);
            if (count == 1) {
//               req.getRequestDispatcher("/cookieUser").forward(req, resp);
//                req.setAttribute("login_error", "登陆成功");
//                resp.sendRedirect(req.getContextPath()+"showtime.jsp");
                resp.getWriter().write("登陆成功");
            }
            else {
                req.setAttribute("login_error", "用户名密码错误，请重新输入");
                req.getRequestDispatcher("/Login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("cc_error", "验证码失败，请重新输入");

            req.getRequestDispatcher("/Login.jsp").forward(req, resp);
           // resp.sendRedirect(req.getContextPath()+"/login.jsp");
        }

    }
}
