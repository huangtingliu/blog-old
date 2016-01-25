package com.coder6.blog.utils;

import javax.servlet.http.HttpServletRequest;

/**
 *描述：
 *创建人:黄廷柳
 *创建日期：2016年1月25日 下午4:15:43
 **/
public class SysUtil {
	public static String getBasePath(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		return basePath;
	}
}
