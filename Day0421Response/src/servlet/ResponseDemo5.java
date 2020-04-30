package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/*验证码*/
@WebServlet("/checkCodeServlet")
public class ResponseDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      1.创建对象，在内存中存储图片
        int width=100;
        int height=50;
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
//        2.美化图片
//        2.1 填充背景
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.pink);
        graphics.fillRect(0,0,width,height);
//        2.2 画边框
        graphics.setColor(Color.blue);
        graphics.drawRect(0,0,width-1,height-1);
//        2.3 写验证码
        String str="QWERTYUIOPLASKDJFHGZMXNCBVzmxncbvalksdjfhgqpoweiruty0123456789";
        Random ran=new Random();
        for (int i = 1; i <= 4; i++) {
            int index=ran.nextInt(str.length());
            char ch=str.charAt(index);
            graphics.drawString(ch+"",width/5*i,height/2);
        }
//        2.4 画干扰线
        graphics.setColor(Color.green);
        for (int i = 0; i < 10; i++) {
            int x1=ran.nextInt(width);
            int x2=ran.nextInt(width);
            int y1=ran.nextInt(height);
            int y2=ran.nextInt(height);
            graphics.drawLine(x1,x2,y1,y2);
        }
//        3.将图片输出到页面展示
        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
