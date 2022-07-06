//package com.FJNU.seed.model;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//@Component // Spring框架扫描本注解会将类的对象实例化并管理
//public class eg_AppSecondHandDao {
//    @Autowired // 通过Spring框架自动注入对象
//    private JdbcTemplate jdbcTemplate;
//
//    public List<eg_AppSecondHand> getSecodeHandGoodsList(Integer pageSize, Integer pageNum) {
//        int limitStart = (pageNum-1) * pageSize;
//        final String sql = "select goodsid,userid,title,content,avatar,status from app_second_hand limit " + limitStart + "," + pageSize;
//        List<eg_AppSecondHand> secondHandGoodsList = jdbcTemplate.query(sql, new AppSecondHandMapper());
//        return secondHandGoodsList;
//    }
//
//    public eg_AppSecondHand getSecodeHandGoodsByGoodsid(final Long goodsid) {
//        final String sql = "select goodsid,userid,title,content,avatar,status from app_second_hand where goodsid='" + goodsid + "' limit 1";
//        List<eg_AppSecondHand> secondHandGoodsList = jdbcTemplate.query(sql, new AppSecondHandMapper());
//        if (secondHandGoodsList == null || secondHandGoodsList.isEmpty()) {
//            return null;
//        }
//        return secondHandGoodsList.get(0);
//    }
//
//    public int createSecodeHandGoodsByGoodsid(eg_AppSecondHand newInfo) {
//        if (newInfo.getCreateTime() == null) {
//            newInfo.setCreateTime(new Date());
//        }
//        newInfo.setUpdateTime(newInfo.getCreateTime());
//        //
//        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        final String sqlPart1 = "INSERT INTO app_second_hand(goodsid,userid,title,content,avatar,status,create_time,update_time) VALUES(";
//        StringBuilder sqlPart2Builder = new StringBuilder();
//        sqlPart2Builder.append(newInfo.getGoodsid()).append(",");
//        sqlPart2Builder.append(newInfo.getUserid()).append(",");
//        sqlPart2Builder.append("'").append(newInfo.getTitle()).append("',");
//        sqlPart2Builder.append("'").append(newInfo.getContent()).append("',");
//        sqlPart2Builder.append("'").append(newInfo.getAvatar()).append("',");
//        sqlPart2Builder.append(newInfo.getStatus()).append(",");
//        sqlPart2Builder.append("'").append(dateFormat.format(newInfo.getCreateTime())).append("',");
//        sqlPart2Builder.append("'").append(dateFormat.format(newInfo.getUpdateTime())).append("')");
//        final String sql = sqlPart1 + sqlPart2Builder.toString();
//        System.out.println(sql);
//        //
//        return jdbcTemplate.update(sql);
//    }
//
//    public int modifySecodeHandGoodsByGoodsid(eg_AppSecondHand newInfo) {
//        final String sqlPart1 = "UPDATE app_second_hand SET ";
//        String sqlPart2 = "";
//        final String sqlPart3 = " WHERE goodsid=" + newInfo.getGoodsid();
//        //
//        if (newInfo.getContent() != null && !newInfo.getContent().isEmpty()) {
//            if (!sqlPart2.isEmpty()) {
//                sqlPart2 += ",";
//            }
//            sqlPart2 += "content='" + newInfo.getContent() + "'";
//        }
//        if (newInfo.getTitle() != null && !newInfo.getTitle().isEmpty()) {
//            if (!sqlPart2.isEmpty()) {
//                sqlPart2 += ",";
//            }
//            sqlPart2 += "title='" + newInfo.getTitle() + "'";
//        }
//        final String sql = sqlPart1 + sqlPart2 + sqlPart3;
//        System.out.println(sql);
//        //
//        return jdbcTemplate.update(sql);
//    }
//
//    class AppSecondHandMapper implements RowMapper<eg_AppSecondHand> {
//        @Override
//        public eg_AppSecondHand mapRow(ResultSet rs, int rowNum) throws SQLException {
//            eg_AppSecondHand secondHandGoods = new eg_AppSecondHand();
//            secondHandGoods.setGoodsid(rs.getLong("goodsid"));
//            secondHandGoods.setUserid(rs.getLong("userid"));
//            secondHandGoods.setTitle(rs.getString("title"));
//            secondHandGoods.setContent(rs.getString("content"));
//            secondHandGoods.setAvatar(rs.getString("avatar"));
//            secondHandGoods.setStatus(rs.getInt("status"));
//            return secondHandGoods;
//        }
//    }
//}
