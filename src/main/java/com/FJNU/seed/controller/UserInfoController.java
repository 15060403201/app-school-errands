package com.FJNU.seed.controller;

import java.util.List;

import com.FJNU.seed.model.UserInfo;
import com.FJNU.seed.model.UserInfoDao;

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
public class UserInfoController {
    @Autowired // 通过Spring框架自动注入对象
    private UserInfoDao userInfoDao;

    @GetMapping("/user_info") // 绑定接口地址yApi
    @ResponseBody // 将返回值序列化为应答内容
    public List<UserInfo> userInfoList(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
    ) {
        List<UserInfo> userInfoList = userInfoDao.getUserInfoList(pageSize, pageNum);
        return userInfoList;
    }

    @GetMapping("/user_info/{id}") // 绑定接口地址，支持获取地址参数
    @ResponseBody // 将返回值序列化为应答内容
    public UserInfo getUserInfoById(
            @PathVariable String id // 从接口地址获取请求参数
    ) {
        UserInfo userInfo = userInfoDao.getUserInfoByAccount(id);
        return userInfo;
    }

    @RequestMapping(path = "/user_info", method = RequestMethod.POST) // 绑定接口地址，支持获取地址参数
    @ResponseBody // 将返回值序列化为应答内容
    public UserInfo createUserInfo(
            @RequestBody UserInfo newInfo) {
        newInfo.setAccount(String.valueOf(System.currentTimeMillis()));//////////////////////
        userInfoDao.createUserInfoByAccount(newInfo);
        return newInfo;
    }

    @RequestMapping(path = "/user_info/{account}", method = RequestMethod.POST) // 绑定接口地址，支持获取地址参数
    @ResponseBody // 将返回值序列化为应答内容
    public UserInfo modifyUserInfo(
            @PathVariable String account, // 从接口地址获取请求参数
            @RequestBody UserInfo newInfo) {
        newInfo.setAccount(account);
      userInfoDao.modifyUserInfoByAccount(newInfo);
        return newInfo;
    }
}

