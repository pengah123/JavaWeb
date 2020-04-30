package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/*获取文件的服务器路径*/
@WebServlet("/ResponseDemo10")
public class ResponseDemo10 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
        ServletContext context = this.getServletContext();
        String realPath1 = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下
        String realPath2 = context.getRealPath("/b.txt");//web目录下
        String realPath3 = context.getRealPath("/WEB-INF/c.txt");//WEB-INFO目录下
        System.out.println(realPath1);
        System.out.println(realPath2);
        System.out.println(realPath3);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
