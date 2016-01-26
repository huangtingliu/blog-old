package com.coder6.blog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *描述：
 *创建人:黄廷柳
 *创建日期：2016年1月25日 下午4:23:14
 **/
@Controller
@RequestMapping("login")
public class LoginService {
	
	private static final Logger log = Logger.getLogger(LoginService.class);
	
	@RequestMapping("toLogin")
	public ModelAndView toLogin(Map<String, Object> model){
		log.info("登录处理");
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", "huangtl");
		map.put("age", "24");
		map.put("sex", "男");
		
		list.add(map);
		model.put("list", list);
		
		ModelAndView mav = new ModelAndView("login", model);
		
		return mav;
	}
}
