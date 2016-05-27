package com.huangtl.blog.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.huangtl.blog.bean.RequestDataBean;

/**
 *描述：请求工具类
 *创建人:黄廷柳
 *创建日期：2016年5月20日 上午10:13:59
 **/
public class RequestUtil {

	public static void putParam(RequestDataBean requestDataBean,
			HttpServletRequest request) {
		//requestDataBean.put("id", "2c30fe83-4c64-1034-bafc-e99f61090b1a");
		Enumeration<String> pNames = request.getParameterNames();
		
		while (pNames.hasMoreElements()) {
			String name = (String) pNames.nextElement();
			//String[] val = request.getParameterValues(name);
			String val = request.getParameter(name);
			val = val == null ? "" : val.trim(); 
			requestDataBean.put(name, val);
		}
	}

}
