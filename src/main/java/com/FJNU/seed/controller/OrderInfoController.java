package com.FJNU.seed.controller;

import com.FJNU.seed.model.OrderInfo;
import com.FJNU.seed.model.OrderInfoDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags={"订单操作接口"})
@RestController
//@RequestMapping("/order_info")

@Controller // Spring框架扫描本注解会将类的对象实例化并管理
public class OrderInfoController {
    @Autowired // 通过Spring框架自动注入对象
    private OrderInfoDao orderInfoDao;
    @ApiOperation(value="订单信息列表",notes="注意问题点")
    @GetMapping("/order_info") // 绑定接口地址
    @ResponseBody // 将返回值序列化为应答内容
    public List<OrderInfo> orderInfoList(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
    ) {
        List<OrderInfo> orderInfoList = orderInfoDao.getOrderInfoList(pageSize, pageNum);
        return orderInfoList;
    }
    //  /test/{account}/{name}   @PathVariable
    //  /test   @RequestParam
//    @GetMapping("/test")
//    public String getOrderInfo(@ApiParam(name="account",value="发布者账号",required=true)@RequestParam String account,
//                               @ApiParam(name="name",value="姓名") @RequestParam String name) {
//
//        return account+name;
//    }

    @ApiOperation(value="获取某一订单信息",notes="注意问题点")
    //http://test.sifei.info/lowcode/api/1010/order_info/1656260963285 ====>/order_info/{orderid}
    //http://test.sifei.info/lowcode/api/1010/order_info?orderid=1656260963285 =====>/order_info
    /**
     * http://test.sifei.info/lowcode/api/1010/order_info?orderid=1656260963285
     * url ：/order_info
     * 请求方法参数：如果参数名一致，则不加注解@RequestParam
     * 如过参数不一致，则@RequestParam（“orderid”）
     */
    @GetMapping("/order_info/{orderid}") // 绑定接口地址，支持获取地址参数
    @ResponseBody // 将返回值序列化为应答内容
    public OrderInfo getOrderInfoByOrderid(
            @PathVariable("orderid")  String orderid // 从接口地址获取请求参数
    ) throws Exception {
        return orderInfoDao.getOrderInfoByOrderid(orderid);
    }

    @ApiOperation(value="创建新的订单信息")
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
