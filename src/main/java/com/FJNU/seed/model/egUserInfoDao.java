//package com.FJNU.seed.model;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
///*import java.text.SimpleDateFormat;
//import java.util.Date;*/
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//@Component // Spring框架扫描本注解会将类的对象实例化并管理
//public class egUserInfoDao {
//    @Autowired // 通过Spring框架自动注入对象
//    private JdbcTemplate jdbcTemplate;
//
//    public List<egUserInfo> getUserInfoList(Integer pageSize, Integer pageNum) {
//        final String sql = "select account,name,gender,phone,idnumber from userinfo";
//        List<egUserInfo> userInfoList = jdbcTemplate.query(sql, new UserInfoMapper());
//        return userInfoList;
//    }
//
//
//
//
//
//    class UserInfoMapper implements RowMapper<egUserInfo> {
//        @Override
//        public egUserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
//            egUserInfo userInfo = new egUserInfo();
//            userInfo.setAccount(rs.getString("account"));
//            userInfo.setName(rs.getString("name"));
//            userInfo.setGender(rs.getString("gender"));
//            userInfo.setPhone(rs.getString("phone"));
//            userInfo.setIdnumber(rs.getString("idnumber"));
//
//            return userInfo;
//        }
//    }
//}
