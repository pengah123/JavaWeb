package login;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.beancontext.BeanContextContainerProxy;

public class UserDoa {
    public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public static User login(User user) {
        try{
            String sql = "select* from usertable where name=? and password=?";
            User result = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getName(), user.getPassword());
            return result;
        }catch (DataAccessException e){
            return null;
        }


    }
}
