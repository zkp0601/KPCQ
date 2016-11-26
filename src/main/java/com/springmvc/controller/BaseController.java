package com.springmvc.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 基类控制器 */
public class BaseController {
	
	protected ApplicationContext context ;
	
	BaseController(){
		context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml", "classpath:conf/spring-mybatis.xml"});
	}
	
}
