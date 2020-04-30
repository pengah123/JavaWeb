package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*cookie 是否能存储中文
* tomcat8之前需要转码*/
@WebServlet("/Demo5")
public class Demo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.创建cookie对象
        Cookie cookie = new Cookie("msg", "你好");
//        2.发送cookie
        response.addCookie(cookie);
//        3.获取cookie数据
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
