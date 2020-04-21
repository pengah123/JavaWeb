package login;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/varify")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
/*        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginuser = new User();
        loginuser.setName(username);
        loginuser.setPassword(password);*/
//使用BeanUtil简化操作
        Map<String,String[]> map=request.getParameterMap();
        User loginuser = new User();
//        将map获取的参数封装到loginuser里面
        try {
            BeanUtils.populate(loginuser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        userdoa doa = new userdoa();
        User getuser = doa.login(loginuser);
        if (getuser == null) {
//                登陆失败的转发
            request.getRequestDispatcher("/failServlet").forward(request, response);
        } else {
//                登陆成功就先存储数据再转发
            request.setAttribute("user", getuser);
            request.getRequestDispatcher("/sucessServlet").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }
}
