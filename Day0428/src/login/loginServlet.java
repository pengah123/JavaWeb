package login;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        获取参数

        User loginuser = new User();
        loginuser.setName(request.getParameter("username"));
        loginuser.setPassword(request.getParameter("password"));
        String checkCode = request.getParameter("checkCode");
//        验证
        User resultUser = UserDoa.login(loginuser);
//        获取验证码
        HttpSession session = request.getSession();
        String check_session = (String) session.getAttribute("check_session");
        //        使用完删除验证码
        session.removeAttribute("check_session");
        if (check_session!=null&&check_session.equalsIgnoreCase(checkCode)) {

//            验证码一致,验证用户名和密码
            if (resultUser == null) {
//                登陆失败
                request.setAttribute("login_msg", "用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
//              登陆成功
//                存储用户信息
                session.setAttribute("user", resultUser.getName());
//                重定向到首页
                response.sendRedirect(request.getContextPath() + "/sucess.jsp");

            }
        } else {

//            验证码不一致
            request.setAttribute("error_msg", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
