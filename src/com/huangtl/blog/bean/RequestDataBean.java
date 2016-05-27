package com.huangtl.blog.bean;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huangtl.blog.utils.RequestUtil;


/**
 *描述：封装请求内容类
 *创建人:黄廷柳
 *创建日期：2016年1月27日 下午4:05:00
 **/
public class RequestDataBean extends HashMap<String, Object>{

	private static final long serialVersionUID = 3168310185320257064L;
	
	/** 成功 */
	public static final String SUCCESSFUL = "1";
	/** 失败 */
	public static final String FAIL = "2";	
	/** 未找到 */
	public static final String NOTFOUND = "4";
	/** 错误异常 */
	public static final String ERROR = "5";
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	

	public RequestDataBean(HttpServletRequest request,
			HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		RequestUtil.putParam(this,request);
	}
	
	public RequestDataBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getString(String key){
		
		return this.request.getParameter(key);
	}
	
	public int getInt(String key){
		return Integer.parseInt(getString(key));
	}
	
}
