package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*代理测试类*/
public class ProxyTest {
    public static void main(String[] args) {
//        创建一个真实对象
        Lenovo lenovo = new Lenovo();
//        动态代理增强lenvov对象
        /*
         * 1.类加载器，真实对象.getClass().getClassLoader()
         * 2.接口数组，真实对象。getClass().getInterfaces()
         * 3.处理器，new InvocationHandler()*/
        saleComputer proxy_lenvov = (saleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /*代理逻辑编写的方法，代理对象调用的所有方法都会触发该方法的执行
             * 参数：
             * 1.proxy
             * 2.method:代理对象调用的方法被封装为的方法
             * 3.args：代理对象调用方法时传递的实际参数
             * */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*System.out.println("代理方法执行了");
                System.out.println(method.getName());
                System.out.println(args[0]);*/
                if (method.getName().equals("sale")) {
                    double money = (double) args[0];
                    money = money * 0.85;
                    System.out.println("专车接您");
                    String obj =(String)method.invoke(lenovo, money);
                    System.out.println("免费送货");
                    return obj+"_鼠标垫";
                } else {
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }

            }
        });
//        调用方法
        String sale = proxy_lenvov.sale(8000);
        System.out.println(sale);
/*        proxy_lenvov.show();*/
    }
}
