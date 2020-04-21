package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*演示request对象获取指定请求头数据*/
@WebServlet("/ServletRequestDemo4")
public class ServletRequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String agent = request.getHeader("referer");
        System.out.println(agent);
        if(agent!=null){
            if(agent.contains("/ServletRequestDemo4")){
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影");
                System.out.println("欢迎观看");
            }
            else {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("请前往——/ServletRequestDemo4");
                System.out.println("请前往——/ServletRequestDemo4");
            }
        }

    }
}
