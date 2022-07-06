//package com.FJNU.seed.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller // Spring框架扫描本注解会将类的对象实例化并管理
//public class eg_GreetingController {
//	@GetMapping("/greeting") // Spring框架会将URL地址和处理函数关联起来
//	public String greeting(
//        @RequestParam(name="name", required=false, defaultValue="World") String name,
//        Model model) {
//		model.addAttribute("name", name);
//		return "greeting";
//	}
//
//	@GetMapping("/greeting/{goodsid}")
//	public String getGoodsInfo(
//        @PathVariable(name="goodsid") String goodsid,
//        @RequestParam(name="name", required=false, defaultValue="World") String name,
//        Model model) {
//		model.addAttribute("name", name + "/" + goodsid);
//		return "greeting";
//	}
//
//	@PostMapping("/greeting/{goodsid}")
//	public String addGoodsInfo(
//        @PathVariable(name="goodsid") String goodsid,
//        @RequestParam(name="name", required=false, defaultValue="World") String name,
//        Model model) {
//		model.addAttribute("name", name + "/" + goodsid);
//		return "greeting";
//	}
//}
