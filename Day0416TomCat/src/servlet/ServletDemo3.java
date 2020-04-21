package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
@WebServlet("/demo3")
public class ServletDemo3 implements Servlet {
    /**
     * init方法：在servlet创建时执行，只执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init=============================");
    }

    /**
     * 获取配置信息，一般不用
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法：每次访问servlet都会执行，执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service=============================");
    }

    /**
     * 获取版本信息等，一般不用
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * destroy方法：销毁方法，在每次服务器正常关闭时执行
     */
    @Override
    public void destroy() {
        System.out.println("destroy============================");
    }
}
