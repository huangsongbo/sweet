package com.amu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

	/**
	 * 引导页
	 * @author huangsongbo
	 * @return
	 */
	@RequestMapping("/index")
	public String homePage(){
		return "/jsp/base/index.jsp";
	}
	
	/**
	 * 首页
	 * @author huangsongbo
	 * @return
	 */
	@RequestMapping("/home")
	public String home(){
		return "/jsp/base/home.jsp";
	}
	
	@RequestMapping("/productPage")
	public String productPage(){
		return "/jsp/product/product_list.jsp";
	}
	
	@RequestMapping("/brandPage")
	public String brandPage(){
		return "/jsp/brand/brand_list.jsp";
	}
	
}
