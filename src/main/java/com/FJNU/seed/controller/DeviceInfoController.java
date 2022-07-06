//package com.FJNU.seed.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.FJNU.seed.domain.ResponseList;
//import com.FJNU.seed.model.eg_DeviceInfo;
//import com.FJNU.seed.model.eg_DeviceInfoDao;
//
//@Controller // Spring框架扫描本注解会将类的对象实例化并管理
//public class DeviceInfoController
//{
//    @Autowired // 通过Spring框架自动注入对象
//    private eg_DeviceInfoDao deviceInfoDao;
//
//    @GetMapping("/devinfo") // 绑定接口地址
//    @ResponseBody // 将返回值序列化为应答内容
//    public ResponseList getDeviceList(
//        @RequestParam(value="pageNum", required=false, defaultValue="1") Integer pageNum,
//        @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize) {
//        // 从数据库查询总数
//        int total = deviceInfoDao.getDeviceTotal();
//        // 从数据库查询设备列表
//        List<eg_DeviceInfo> deviceList = deviceInfoDao.getDeviceList(pageNum, pageSize);
//        // 构造返回应答
//        ResponseList responseList = new ResponseList();
//        responseList.setTotal(total);
//        responseList.setList(deviceList);
//        return responseList;
//    }
//}