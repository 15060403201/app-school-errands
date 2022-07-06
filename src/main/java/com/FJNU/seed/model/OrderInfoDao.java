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
public class OrderInfoDao {
    @Autowired // 通过Spring框架自动注入对象
    private JdbcTemplate jdbcTemplate;

    public List<OrderInfo> getOrderInfoList(Integer pageSize, Integer pageNum) {
        final String sql = "select orderid,account,name,phone,address0,quantity,address1,detail,price from orderinfo";
        List<OrderInfo> orderInfoList = jdbcTemplate.query(sql, new OrderInfoMapper());
        return orderInfoList;
    }

    public OrderInfo getOrderInfoByOrderid(final String orderid) {
        final String sql = "select orderid,account,name,phone,address0,quantity,address1,detail,price from orderinfo where orderid='" + orderid + "' limit 1";
        List<OrderInfo> orderInfoList = jdbcTemplate.query(sql, new OrderInfoMapper());
        if (orderInfoList == null || orderInfoList.isEmpty()) {
            return null;
        }
        return orderInfoList.get(0);
    }

    public int createOrderInfoByOrderid(OrderInfo newInfo) {
            final String sqlPart1 = "INSERT INTO orderinfo(orderid,account,name,phone,address0,quantity,address1,detail,price) VALUES(";
            StringBuilder sqlPart2Builder = new StringBuilder();
            sqlPart2Builder.append(newInfo.getOrderid()).append(",");
            sqlPart2Builder.append("'").append(newInfo.getAccount()).append("',");
            sqlPart2Builder.append("'").append(newInfo.getName()).append("',");
            sqlPart2Builder.append("'").append(newInfo.getPhone()).append("',");
            sqlPart2Builder.append("'").append(newInfo.getAddress0()).append("',");
            sqlPart2Builder.append("'").append(newInfo.getQuantity()).append("',");
            sqlPart2Builder.append("'").append(newInfo.getAddress1()).append("',");
            sqlPart2Builder.append("'").append(newInfo.getDetail()).append("',");
            sqlPart2Builder.append("'").append(newInfo.getPrice()).append("')");
            final String sql = sqlPart1 + sqlPart2Builder.toString();
            System.out.println(sql);

            return jdbcTemplate.update(sql);
    }

    public int modifyOrderInfoByOrderid(OrderInfo newInfo) {
        final String sqlPart1 = "UPDATE orderinfo SET ";
        String sqlPart2 = "";
        final String sqlPart3 = " WHERE orderid=" + newInfo.getOrderid();

        if (newInfo.getDetail() != null && !newInfo.getDetail().isEmpty()) {
            if (!sqlPart2.isEmpty()) {
                sqlPart2 += ",";
            }
            sqlPart2 += "detail='" + newInfo.getDetail() + "'";
        }
        final String sql = sqlPart1 + sqlPart2 + sqlPart3;
        System.out.println(sql);

        return jdbcTemplate.update(sql);
    }



    class OrderInfoMapper implements RowMapper<OrderInfo> {
        @Override
        public OrderInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrderid(rs.getString("orderid"));
            orderInfo.setAccount(rs.getString("account"));
            orderInfo.setName(rs.getString("name"));
            orderInfo.setPhone(rs.getString("phone"));
            orderInfo.setAddress0(rs.getString("address0"));
            orderInfo.setQuantity(rs.getString("quantity"));
            orderInfo.setAddress1(rs.getString("address1"));
            orderInfo.setDetail(rs.getString("detail"));
            orderInfo.setPrice(rs.getString("price"));
            return orderInfo;
        }
    }
}
