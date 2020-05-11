package Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    /**
     * 服务器启动后自动调用
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        加载资源,配置参数在web.xml
        ServletContext servletContext = servletContextEvent.getServletContext();
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
//        获取真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);
//        加载进内存
        try {
            FileInputStream fis = new FileInputStream(realPath);
            System.out.println(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("servletContext对象被创建了……");
    }

    /**
     * 服务器正常关闭后自动调用
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("servletContext对象被销毁了……");
    }
}
