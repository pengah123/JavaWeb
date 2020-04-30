package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*服务器输出字符流到浏览器*/
@WebServlet("/ResponseDemo3")
public class ResponseDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取流对象之前设置流的默认编码为GBK
        response.setCharacterEncoding("utf-8");
//        告诉浏览器服务器发送消息的编码，建议浏览器使用该编码
//        response.setHeader("content-type","text/html;charset=utf-8");
//        简单的形式来设置编码
        response.setContentType("text/html;charset=utf-8");
//        获取字符输出流
        PrintWriter pw = response.getWriter();
//        输出到页面
        pw.write("<h1>hello response</h1>");
//        中文乱码问题
        pw.write("你好啊");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
