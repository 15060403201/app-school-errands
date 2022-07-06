package com.FJNU.seed.controller;

import java.util.List;

import com.FJNU.seed.model.Login;
import com.FJNU.seed.model.LoginDao;

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

public class LoginController {
    @Autowired // 通过Spring框架自动注入对象
    private LoginDao loginDao;

    @GetMapping("/login") // 绑定接口地址yApi
    @ResponseBody // 将返回值序列化为应答内容
    public List<Login> loginList(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
    ) {
        List<Login> loginList = loginDao.getLoginList(pageSize, pageNum);
        return loginList;
    }
}
