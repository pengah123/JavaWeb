package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*可以创建多个cookie对象*/
@WebServlet("/Demo3")
public class Demo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.创建cookie对象
        Cookie cookie = new Cookie("msg", "hello");
        Cookie cookie2 = new Cookie("name", "zhangsan");
//        2.发送cookie
        response.addCookie(cookie);
        response.addCookie(cookie2);
//        3.获取cookie数据
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
