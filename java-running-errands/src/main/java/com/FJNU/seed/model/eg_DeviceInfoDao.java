//package com.FJNU.seed.model;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//@Component
//public class eg_DeviceInfoDao
//{
//    @Autowired // 通过Spring框架自动注入对象
//    private JdbcTemplate jdbcTemplate;
//
//    public List<eg_DeviceInfo> getDeviceList(Integer pageNum, Integer pageSize) {
//        // final String sql = "select devid,devmac,devtype,hardver,softver from dev_info";
//        int start = (pageNum-1)*pageSize;
//        final String sql = "select devid,devmac,devtype,hardver,softver from dev_info limit "+start+","+pageSize;
//        List<eg_DeviceInfo> deviceInfoList = jdbcTemplate.query(sql, new DeviceInfoMapper());
//        return deviceInfoList;
//    }
//
//    /**
//     * 查询设备总数
//     */
//    public int getDeviceTotal() {
//        final String sql = "select count(*) from dev_info";
//        int count = jdbcTemplate.queryForObject(sql, Integer.class);
//        return count;
//    }
//    class DeviceInfoMapper implements RowMapper<eg_DeviceInfo> {
//        @Override
//        public eg_DeviceInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
//            eg_DeviceInfo deviceInfo = new eg_DeviceInfo();
//            deviceInfo.setDevid(rs.getLong("devid"));
//            deviceInfo.setDevmac(rs.getString("devmac"));
//            deviceInfo.setDevtype(rs.getInt("devtype"));
//            deviceInfo.setHardver(rs.getString("hardver"));
//            deviceInfo.setSoftver(rs.getString("softver"));
//            return deviceInfo;
//        }
//    }
//}