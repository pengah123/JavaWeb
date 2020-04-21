package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*演示request对象获取请求行数据*/
@WebServlet("/ServletRequestDemo1")
public class ServletRequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();
        String protocol = request.getProtocol();
        String remoteAddr = request.getRemoteAddr();
        System.out.println("方法："+method);
        System.out.println("虚拟路径："+contextPath);
        System.out.println("servlet路径："+servletPath);
        System.out.println("uri路径："+requestURI);
        System.out.println("内容："+queryString);
        System.out.println("协议："+protocol);
        System.out.println("客户机IP："+remoteAddr);
    }
}
