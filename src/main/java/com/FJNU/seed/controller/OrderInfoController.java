package com.FJNU.seed.controller;

import java.util.List;

import com.FJNU.seed.model.OrderInfo;
import com.FJNU.seed.model.OrderInfoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Spring框架扫描本注解会将类的对象实例化并管理
public class OrderInfoController {
    @Autowired // 通过Spring框架自动注入对象
    private OrderInfoDao orderInfoDao;

    @GetMapping("/order_info") // 绑定接口地址yApi
    @ResponseBody // 将返回值序列化为应答内容
    public List<OrderInfo> orderInfoList(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
    ) {
        List<OrderInfo> orderInfoList = orderInfoDao.getOrderInfoList(pageSize, pageNum);
        return orderInfoList;
    }

    @GetMapping("/order_info/{orderid}") // 绑定接口地址，支持获取地址参数
    @ResponseBody // 将返回值序列化为应答内容
    public OrderInfo getOrderInfoByOrderid(
            @PathVariable String orderid // 从接口地址获取请求参数
    ) {
        OrderInfo orderInfo = orderInfoDao.getOrderInfoByOrderid(orderid);
        return orderInfo;
    }

    @RequestMapping(path = "/order_info", method = RequestMethod.POST) // 绑定接口地址，支持获取地址参数
    @ResponseBody // 将返回值序列化为应答内容
    public OrderInfo createOrderInfo(
            @RequestBody OrderInfo newInfo) {
        newInfo.setOrderid(String.valueOf(System.currentTimeMillis()));//////////////////////
        orderInfoDao.createOrderInfoByOrderid(newInfo);
        return newInfo;
    }

    @RequestMapping(path = "/order_info/{orderid}", method = RequestMethod.POST) // 绑定接口地址，支持获取地址参数
    @ResponseBody // 将返回值序列化为应答内容
    public OrderInfo modifyOrderInfo(
            @PathVariable String orderid, // 从接口地址获取请求参数
            @RequestBody OrderInfo newInfo) {
        newInfo.setOrderid(orderid);
        orderInfoDao.modifyOrderInfoByOrderid(newInfo);
        return newInfo;
    }
}
