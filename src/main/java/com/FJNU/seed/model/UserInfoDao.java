package com.FJNU.seed.model;

import java.sql.ResultSet;
import java.sql.SQLException;
/*import java.text.SimpleDateFormat;
import java.util.Date;*/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component // Spring框架扫描本注解会将类的对象实例化并管理
public class UserInfoDao {
    @Autowired // 通过Spring框架自动注入对象
    private JdbcTemplate jdbcTemplate;

    public List<UserInfo> getUserInfoList(Integer pageSize, Integer pageNum) {
        final String sql = "select id,name,gender,phone,idnumber,password from userinfo";
        List<UserInfo> userInfoList = jdbcTemplate.query(sql, new UserInfoMapper());
        return userInfoList;
    }

    public UserInfo getUserInfoById(final String id) {
        final String sql = "select id,name,gender,phone,idnumber,password from userinfo where id='" + id + "' limit 1";
        System.out.println(id);
        System.out.println(sql);
        List<UserInfo> userInfoList = jdbcTemplate.query(sql, new UserInfoDao.UserInfoMapper());
        if (userInfoList == null || userInfoList.isEmpty()) {
            return null;
        }
        return userInfoList.get(0);
    }

    public int createUserInfoById(UserInfo newInfo) {
        final String sqlPart1 = "INSERT INTO userinfo(id,password,name,gender,phone,idnumber) VALUES(";
        StringBuilder sqlPart2Builder = new StringBuilder();
        sqlPart2Builder.append("'").append(newInfo.getId()).append("',");
        sqlPart2Builder.append("'").append(newInfo.getPassword()).append("',");
        sqlPart2Builder.append("'").append(newInfo.getName()).append("',");
        sqlPart2Builder.append("'").append(newInfo.getGender()).append("',");
        sqlPart2Builder.append("'").append(newInfo.getPhone()).append("',");
        sqlPart2Builder.append("'").append(newInfo.getIdnumber()).append("')");
        final String sql = sqlPart1 + sqlPart2Builder.toString();
        System.out.println(sql);

        return jdbcTemplate.update(sql);
    }

    public int modifyUserInfoById(UserInfo newInfo) {
        final String sqlPart1 = "UPDATE userinfo SET ";
        String sqlPart2 = "";
        final String sqlPart3 = " WHERE id=" + newInfo.getId();

        final String sql = sqlPart1 + sqlPart2 + sqlPart3;
        System.out.println(sql);

        return jdbcTemplate.update(sql);
    }



    class UserInfoMapper implements RowMapper<UserInfo> {
        @Override
        public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(rs.getString("id"));
            userInfo.setName(rs.getString("name"));
            userInfo.setGender(rs.getString("gender"));
            userInfo.setPhone(rs.getString("phone"));
            userInfo.setIdnumber(rs.getString("idnumber"));
            userInfo.setPassword(rs.getString("password"));

            return userInfo;
        }
    }
}
