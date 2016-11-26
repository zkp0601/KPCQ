package com.springmvc.service.impl;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.springmvc.service.DealReqService;

@Service
@Configuration
public class DealReqServiceImpl implements DealReqService{

	@Override
	public void dealReq(String param) {
		System.out.println("本方法作为 DealReqService 接口类中对应方法的实现");
	}
}
