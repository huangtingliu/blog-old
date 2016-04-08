package com.huangtl.blog.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import com.huangtl.blog.bean.RequestDataBean;
import com.huangtl.blog.mapper.BlogMapper;

/**
 *描述：登录模块
 *创建人:黄廷柳
 *创建日期：2016年1月25日 下午4:23:14
 **/
@Controller
public class BlogService {
	
	private static final Logger log = Logger.getLogger(BlogService.class);
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbc;
	@Autowired
	private BlogMapper blogMapper;
	
	/**
	 * 
	 * TODO 发布博文
	 * 作者：黄廷柳
	 * 2016年4月5日下午4:57:44
	 */
	public RequestDataBean issueBlog(RequestDataBean rdb){
		log.info("发布博文...");
		
		blogMapper.issueBlog();
		rdb.setStatus(RequestDataBean.SUCCESSFUL);
		
		return rdb;
	}
	
}
