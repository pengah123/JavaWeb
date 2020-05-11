package filterDemo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*拦截方式*/
//@WebFilter(value="/index.jsp" , dispatcherTypes ={DispatcherType.FORWARD,DispatcherType.REQUEST})
public class FilterDemo5 implements Filter {
    /**
     * 服务器关闭后执行一次
     */
    public void destroy() {
        System.out.println("destroy……");
    }

    /**
     * 每次拦截路径时执行
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("FilterDemo5执行了……");
        chain.doFilter(req, resp);

    }

    /**
     * 服务器启动时执行一次
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init……");
    }

}
