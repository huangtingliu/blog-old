package com.coder6.blog.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *描述：
 *创建人:黄廷柳
 *创建日期：2016年1月25日 下午4:23:14
 **/
@Controller
@RequestMapping("login")
public class LoginService {
	
	@RequestMapping("toLogin")
	public String toLogin(){
		System.out.println("正在跳转到登录页...");
		return "login";
	}
}
