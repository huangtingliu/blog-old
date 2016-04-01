package com.huangtl.blog.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huangtl.blog.init.Initial;
import com.huangtl.blog.mapper.User;
import com.huangtl.blog.utils.SpringContextUtil;
import com.mysql.jdbc.AssertionFailedException;

/**
 *描述：junit测试mybatis配置
 *创建人:黄廷柳
 *创建日期：2016年3月25日 上午9:51:33
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/junit-springmvc-servlet.xml"})
public class TestMybatis {

	@Autowired
	private User user;
	
	@Before
	public void before() {
	}
	@After
	public void after() {
	}
	
	@Test
	public void interfaceMapperProxy() {
		List<?> list = user.userList();
		assertNotNull(user);//测试mybatis接口映射
	}
	@Test
	public void test() {
		try {
			List<?> list = user.userList();
		} catch (Exception e) {
			// TODO: handle exception
			fail("接口映射xml错误");
		}
		
	}
}
