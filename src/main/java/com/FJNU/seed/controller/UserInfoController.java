package com.FJNU.seed.controller;

import com.FJNU.seed.model.UserInfo;
import com.FJNU.seed.model.UserInfoDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Api(tags={"用户操作接口"})
@RestController
//@RequestMapping("/user_info")

@Controller // Spring框架扫描本注解会将类的对象实例化并管理
public class UserInfoController {
    @Autowired // 通过Spring框架自动注入对象
    private UserInfoDao userInfoDao;
    @ApiOperation(value="用户信息列表",notes="注意问题点")
    @GetMapping("/user_info") // 绑定接口地址
    @ResponseBody // 将返回值序列化为应答内容
    public List<UserInfo> userInfoList(
            @ApiParam("当前页数") @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @ApiParam("每页条数")@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
    ) {
        List<UserInfo> userInfoList = userInfoDao.getUserInfoList(pageSize, pageNum);
        return userInfoList;
    }
    @ApiOperation(value="获取某一用户信息",notes="注意问题点")
    @GetMapping("/user_info/{id}") // 绑定接口地址，支持获取地址参数
    @ResponseBody // 将返回值序列化为应答内容
    public UserInfo getUserInfoById(
            @PathVariable("id") String id // 从接口地址获取请求参数
    ) {
        UserInfo userInfo = userInfoDao.getUserInfoById(id);
        return userInfo;
    }

    @RequestMapping(path = "/user_info", method = RequestMethod.POST) // 绑定接口地址，支持获取地址参数
    @ResponseBody // 将返回值序列化为应答内容
    public UserInfo createUserInfo(
            @RequestBody UserInfo newInfo) {
        newInfo.setId(String.valueOf(System.currentTimeMillis()));//////////////////////
        userInfoDao.createUserInfoById(newInfo);
        return newInfo;
    }

    @RequestMapping(path =  "/user_info/{id}", method = RequestMethod.POST) // 绑定接口地址，支持获取地址参数
    @ResponseBody // 将返回值序列化为应答内容
    public UserInfo modifyUserInfo(
            @PathVariable String id, // 从接口地址获取请求参数
            @RequestBody UserInfo newInfo) {
        newInfo.setId(id);
      userInfoDao.modifyUserInfoById(newInfo);
        return newInfo;
    }
}

