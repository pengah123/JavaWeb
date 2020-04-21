package login;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/*操作usertable的方法*/
public class userdoa {
//    声明一个jdbcTemplate对象公用
    public JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     *
     * @param user:接收用户名和密码
     * @return：包含用户全部信息
     * @throws Exception
     */
    public User login(User user) {

//        查询是否存在用户名和密码
        try {
            String sql = "Select* from usertable where name=? and password=?";
            User result = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getName(), user.getPassword());
            return result;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
