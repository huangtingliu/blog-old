package com.coder6.blog.controller;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coder6.blog.bean.RequestDataBean;
import com.coder6.blog.utils.SpringContextUtil;

/**
 * 描述： 请求统一入口
 * 创建人:黄廷柳 
 * 创建日期：2016年1月27日 上午11:20:22
 **/
@Controller
@RequestMapping("/base")
public class BaseController {

	
	/**
	 * TODO	前台请求调用方法，拥有跳转页面，可能有传值
	 * 作者：黄廷柳
	 * 2016年1月27日下午3:52:34
	 */
	@RequestMapping(value = "/{service}/{method}")
	public String base(@PathVariable String service,@PathVariable String method, HttpServletRequest request,
			HttpServletResponse response,Model model) throws Exception{

		//封装requestDataBean
		RequestDataBean requestDataBean = new RequestDataBean(request, response);
		
		//通过上下文获取实例bean,前台访问/base/login/toLogin,则访问loginService的toLogin方法
		Object bean = SpringContextUtil.getBean(service+"Service");
		//获取实例class
		Class<?> c = bean.getClass();
		//根据方法名与参数获取实例方法
		Method m = c.getDeclaredMethod(method,RequestDataBean.class);
		
		//执行实例方法，放回封装bean
		requestDataBean = (RequestDataBean) m.invoke(c.newInstance(),requestDataBean);
		
		//保存返回值，前台可以获取
		model.addAttribute("requestDataBean",requestDataBean);
		
		//返回跳转页
		return requestDataBean.getPage();
		
//		有两种方式向前台传值（参数为map返回ModelAndView）,这里不推荐参数用Map的这种方式
		//第一种
//		model.put("list", list);
//		ModelAndView mav = new ModelAndView("login", model);
//		return mav;
		//第二种
//		本方法有Model model参数
//		直接model.addAttribute("list", list);
//		return String类型表示返回页面目录
		
		
		//相应service配置RequestMapping时可通过下方访问，但是多次一举，因为可以直接访问
//		System.out.println("base..."+"forward:/"+service+"/"+method);
//		request.setAttribute("requestPath", service);
//		return "forward:/"+service+"/"+method;
	}
	
	/**
	 * TODO ajax请求统一调用接口
	 * 作者：黄廷柳
	 * 2016年1月27日下午5:04:10
	 */
	@RequestMapping(value = "/ajax/{ser}/{method}")
	public @ResponseBody Object ajax(@PathVariable String service,@PathVariable String method, HttpServletRequest request,
			HttpServletResponse response,Model model) throws Exception{
		
		
		//封装requestDataBean
		RequestDataBean requestDataBean = new RequestDataBean(request, response);
		
		//通过上下文获取实例bean,前台访问/base/login/toLogin,则访问loginService的toLogin方法
		Object bean = SpringContextUtil.getBean(service+"Service");
		
		//获取实例class
		Class<?> c = bean.getClass();
		
		//根据方法名与参数获取实例方法
		Method m = c.getDeclaredMethod(method,RequestDataBean.class);
		
		//返回实例执行返回值（前台页面与值）
		return m.invoke(c.newInstance(),requestDataBean);
	}
}