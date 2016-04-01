package com.huangtl.blog.init;

import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;
/**
 *描述：初始化参数
 *创建人:黄廷柳
 *创建日期：2016年1月26日 下午5:15:45
 **/
public class Initial implements ServletContextAware{
	private ServletContext sc; 

	public String resRoot;
	
	@Override
	public void setServletContext(ServletContext arg0) {
		// 实现如下:
		sc = arg0;
	}

	public void init() {
		resRoot = "/res-" + new Date().getTime();
		sc.setAttribute("ctxPath", sc.getContextPath());
		sc.setAttribute("resRoot", sc.getContextPath() + resRoot);
	}
}
