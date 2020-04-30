package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*cookie 获取的范围，同一服务器*/
@WebServlet("/Demo6")
public class Demo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.创建cookie对象
        Cookie cookie = new Cookie("msg", "你好");
//        1.1 设置cookie获取范围
//        /表示设置为当前服务器下的所有路径
        cookie.setPath("/");
//        2.发送cookie
        response.addCookie(cookie);
//        3.获取cookie数据
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
