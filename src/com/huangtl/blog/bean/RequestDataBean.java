package com.huangtl.blog.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *描述：封装请求内容类
 *创建人:黄廷柳
 *创建日期：2016年1月27日 下午4:05:00
 **/
public class RequestDataBean {

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
	private Object resultData; //返回值
	private String page;//返回跳转页面
	private String info;//返回提示信息
	

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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getString(String key){
		
		return this.request.getParameter(key);
	}
	
	public int getInt(String key){
		return Integer.parseInt(getString(key));
	}
	
}
