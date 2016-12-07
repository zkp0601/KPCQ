package com.springmvc.service.impl;

import javax.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.springmvc.dao.IUserDAO;
import com.springmvc.model.User;
import com.springmvc.service.RegisterService;
@Service
@Configuration
public class RegisterServiceImpl implements RegisterService{

	@Resource 
	private IUserDAO iUserdao;
	@Override
	public String registerUser(User user) {
		iUserdao.insertUser(user);
		return "true";
	}
	

}
