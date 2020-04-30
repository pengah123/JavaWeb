package DownloadDemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
/*文件下载需求
* 1.页面显示超链接
* 2.点击超链接后弹出下载提示框
* 完成图片文件下载*/
/*实现步骤
* 1.定义页面超链接，指向Servlet，传递资源名称
* 2.定义Servlet，获取文件名称，用字节输入流加载文件进内存，指定response的响应头设置资源打开方式，写出到response的输出流*/
@WebServlet( "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*获取文件名称*/
        String filename = request.getParameter("filename");
        /*获取文件真实路径*/
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename);
        /*关联字节流*/
        FileInputStream fis = new FileInputStream(realPath);
        /*设置响应头类型*/
        String mimeType = context.getMimeType(filename);
        response.setHeader("content-type",mimeType);
        /*使用响应头设置资源打开方式，设置之后不会再浏览器直接下载,加上一个弹出框*/
        response.setHeader("content-disposition","attachment;filename="+filename);
        /*将输入流的数据写出到输出流*/
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buff=new byte[1024*8];
        int len=0;
        while ((len=fis.read(buff))!=-1){
            outputStream.write(buff,0,len);
        }
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
