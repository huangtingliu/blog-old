package com.huangtl.blog.bean;

/**
 * 
 * @author 黄廷柳
 * @todo 返回封装类
 * @时间  2016年5月16日下午5:34:24
 */
public class ResponseDataBean {

	/** 成功 */
	public static final String SUCCESSFUL = "1";
	/** 失败 */
	public static final String FAIL = "2";	
	/** 未找到 */
	public static final String NOTFOUND = "4";
	/** 错误异常 */
	public static final String ERROR = "5";
	
	private Object status; //返回状态(1:成功 2:失败)
	private Object resultData; //返回值
	private String page;//返回跳转页面
	private String info;//返回提示信息
	

	public ResponseDataBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}

	public Object getStatus() {
		return status;
	}

	public void setStatus(Object status) {
		this.status = status;
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

	
	
}
