package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sucessServlet")
public class sucessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取request域中共享的user对象
        User user = (User)request.getAttribute("user");
        if(user!=null){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("登陆成功，"+user.getName()+"，欢迎您");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
