package com.FJNU.seed.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
/*import java.text.SimpleDateFormat;
import java.util.Date;*/
import java.util.List;

@Component // Spring框架扫描本注解会将类的对象实例化并管理
public class LoginDao {
    @Autowired // 通过Spring框架自动注入对象
    private JdbcTemplate jdbcTemplate;

    public List<Login> getLoginList(Integer pageSize, Integer pageNum) {
        final String sql = "select account,password from login";
        List<Login> loginList = jdbcTemplate.query(sql, new LoginMapper());
        return loginList;
    }




    class LoginMapper implements RowMapper<Login> {
        @Override
        public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
            Login login = new Login();
            login.setAccount(rs.getString("account"));
            login.setPassword(rs.getString("password"));
            return login;
        }
    }
}

