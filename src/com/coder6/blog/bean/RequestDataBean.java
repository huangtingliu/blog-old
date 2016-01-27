package com.coder6.blog.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *描述：封装请求内容类
 *创建人:黄廷柳
 *创建日期：2016年1月27日 下午4:05:00
 **/
public class RequestDataBean {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private Object resultData; //返回值
	private String page;//返回跳转页面
	

	public RequestDataBean(HttpServletRequest request,
			HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
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
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}

	public Object getResultData() {
		return resultData;
	}

	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}

	
	
}
