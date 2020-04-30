package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
/*案例改进*/
@WebServlet("/Demo9")
public class Demo9 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        PrintWriter writer = response.getWriter();
        boolean flag=false;
        if(cookies!=null&&cookies.length!=0){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("lt")){
                    String value = cookie.getValue();
                    String decodevalue = URLDecoder.decode(value, "utf-8");
                    writer.write("欢迎访问，上一次访问时间是："+decodevalue);
                    System.out.println("欢迎访问，上一次访问时间是："+decodevalue);
                    flag=true;
                    break;
                }
            }
        }

        if(!flag){
            writer.write("欢迎访问，这是第一次访问");
            System.out.println("欢迎访问，这是第一次访问");

        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date data = new Date();
        String date = df.format(data);
        String encodedate = URLEncoder.encode(date, "utf-8");
        Cookie lt = new Cookie("lt",encodedate);
        lt.setMaxAge(60*60*24*30);
        response.addCookie(lt);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
