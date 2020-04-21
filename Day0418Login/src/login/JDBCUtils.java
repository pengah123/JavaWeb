package login;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

//操作druid连接池的工具类
public class JDBCUtils {
//    获取连接池对象
    public static DataSource ds;
    static {
//        加载配置文件，

        try {
            Properties pro=new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("Druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        初始化连接池对象
    }

    public static DataSource getDataSource(){
        return ds;
    }
//    获取connection对象
    public static Connection conn;
}
