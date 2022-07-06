//package com.FJNU.seed.controller;
//
//import java.util.List;
//
//import com.FJNU.seed.model.eg_AppSecondHand;
//import com.FJNU.seed.model.eg_AppSecondHandDao;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller // Spring框架扫描本注解会将类的对象实例化并管理
//public class AppSecondHandController {
//    @Autowired // 通过Spring框架自动注入对象
//    private eg_AppSecondHandDao appSecondHandDao;
//
//    @GetMapping("/appsecondhand") // 绑定接口地址yApi
//    @ResponseBody // 将返回值序列化为应答内容
//    public List<eg_AppSecondHand> getAppSecondGoodsList(
//        @RequestParam(value="pageNum", required=false, defaultValue="1") Integer pageNum,
//        @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize
//    ) {
//        List<eg_AppSecondHand> secondHandGoodsList = appSecondHandDao.getSecodeHandGoodsList(pageSize, pageNum);
//        return secondHandGoodsList;
//    }
//
//    @GetMapping("/appsecondhand/{goodsid}") // 绑定接口地址，支持获取地址参数
//    @ResponseBody // 将返回值序列化为应答内容
//    public eg_AppSecondHand getAppSecondGoodsByGoodsid(
//        @PathVariable Long goodsid // 从接口地址获取请求参数
//        ) {
//        eg_AppSecondHand secondHandGoods = appSecondHandDao.getSecodeHandGoodsByGoodsid(goodsid);
//        return secondHandGoods;
//    }
//
//    @RequestMapping(path="/appsecondhand", method=RequestMethod.POST) // 绑定接口地址，支持获取地址参数
//    @ResponseBody // 将返回值序列化为应答内容
//    public eg_AppSecondHand createAppSecondGoods(
//        @RequestBody eg_AppSecondHand newInfo) {
//        newInfo.setGoodsid(System.currentTimeMillis());
//        appSecondHandDao.createSecodeHandGoodsByGoodsid(newInfo);
//        return newInfo;
//    }
//
//    @RequestMapping(path="/appsecondhand/{goodsid}", method=RequestMethod.POST) // 绑定接口地址，支持获取地址参数
//    @ResponseBody // 将返回值序列化为应答内容
//    public eg_AppSecondHand modifyAppSecondGoods(
//        @PathVariable Long goodsid, // 从接口地址获取请求参数
//        @RequestBody eg_AppSecondHand newInfo) {
//        newInfo.setGoodsid(goodsid);
//        appSecondHandDao.modifySecodeHandGoodsByGoodsid(newInfo);
//        return newInfo;
//    }
//}
