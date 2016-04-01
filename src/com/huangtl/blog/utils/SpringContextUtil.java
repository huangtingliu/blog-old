package com.huangtl.blog.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *描述：
 *创建人:黄廷柳
 *创建日期：2016年1月27日 下午2:25:19
 **/
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		SpringContextUtil.applicationContext = arg0;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static boolean containsBean(String arg0) {
		return applicationContext.containsBean(arg0);
	}

	/**
	  * 如果给定的bean名字在bean定义中有别名，则返回这些别名   
	  * @param name
	  * @return
	  * @throws NoSuchBeanDefinitionException
	  */
	public static String[] getAliases(String arg0) {
		return applicationContext.getAliases(arg0);
	}

	public static String getApplicationName() {
		return applicationContext.getApplicationName();
	}

	/**
	  * 获取类型为requiredType的对象
	  * 如果bean不能被类型转换，相应的异常将会被抛出（BeanNotOfRequiredTypeException）
	  * @param name       bean注册名
	  * @param requiredType 返回对象类型
	  * @return Object 返回requiredType类型对象
	  * @throws BeansException
	  */
	public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
		return applicationContext.getBean(name, requiredType);
	}

	public static Object getBean(String arg0, Object... arg1) throws BeansException {
		return applicationContext.getBean(arg0, arg1);
	}

	/**
	  * 获取对象   
	  * @param name
	  * @return Object 一个以所给名字注册的bean的实例
	  * @throws BeansException
	  */
	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}

	public static Class<?> getType(String arg0) throws NoSuchBeanDefinitionException {
		return applicationContext.getType(arg0);
	}
	
	

}
