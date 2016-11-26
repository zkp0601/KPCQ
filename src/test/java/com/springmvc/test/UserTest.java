package com.springmvc.test;


import javax.annotation.Resource;

import org.junit.Test;

import com.springmvc.common.SpringTestCase;
import com.springmvc.service.DealReqService;

public class UserTest extends SpringTestCase{
	
	@Resource
	private DealReqService dealReqService;
	
	@Test
	public void test(){
		System.out.println("hello world");
		dealReqService.dealReq(null);
	}
}
