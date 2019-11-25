package cn.itcast.web.login;

import cn.itcast.web.jdbcutils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by cdx on 2019/10/30.
 * desc:
 */
public class UserDao {
    private static final String TAG = "UserDao";

    public int login(User loginUser) {

        String sql = "select count(id) from student where username='" + loginUser.getUsername() + "' and password='" + loginUser.getPassword() + "'";

        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

        return template.queryForObject(sql, int.class);
    }
}
