package com.FJNU.seed.controller;

import com.FJNU.seed.model.Login;
import com.FJNU.seed.model.LoginDao;

import com.FJNU.seed.model.OrderInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags={"登录操作接口"})
@RestController
//@RequestMapping("/login")

@Controller // Spring框架扫描本注解会将类的对象实例化并管理
public class LoginController {
    @Autowired // 通过Spring框架自动注入对象
    private LoginDao loginDao;
    @ApiOperation(value="账号信息列表",notes="注意问题点")
    @GetMapping("/login") // 绑定接口地址yApi
    @ResponseBody // 将返回值序列化为应答内容
    public List<Login> loginList(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
    ) {
        List<Login> loginList = loginDao.getLoginList(pageSize, pageNum);
        return loginList;
    }
//    @ApiOperation(value="获取某一订单信息",notes="注意问题点")
//    @GetMapping("/{orderid}") // 绑定接口地址，支持获取地址参数
//    @ResponseBody // 将返回值序列化为应答内容
//    public OrderInfo getOrderInfoByOrderid(
//            @PathVariable("orderid")  String orderid // 从接口地址获取请求参数
//    ) {
//        OrderInfo orderInfo = orderInfoDao.getOrderInfoByOrderid(orderid);
//        return orderInfo;
//    }

    @ApiOperation(value="创建新的账号密码")
    @RequestMapping(path = "/login", method = RequestMethod.POST) // 绑定接口地址，支持获取地址参数
    @ResponseBody // 将返回值序列化为应答内容
    public Login createLogin(
            @RequestBody Login newInfo) {
        newInfo.setAccount(String.valueOf(System.currentTimeMillis()));//////////////////////
       loginDao.createLoginByAccount(newInfo);
        return newInfo;
    }

    @RequestMapping(path = "/login/{account}", method = RequestMethod.POST) // 绑定接口地址，支持获取地址参数
    @ResponseBody // 将返回值序列化为应答内容
    public Login modifyLogin(
            @PathVariable String account, // 从接口地址获取请求参数
            @RequestBody Login newInfo) {
        newInfo.setAccount(account);
        loginDao. modifyLoginByAccount(newInfo);
        return newInfo;
    }
}

