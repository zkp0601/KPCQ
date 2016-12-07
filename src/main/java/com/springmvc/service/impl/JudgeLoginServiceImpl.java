package com.springmvc.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springmvc.dao.IUserDAO;
import com.springmvc.model.User;
import com.springmvc.service.JudgeLoginService;

@Service
@Configuration

public class JudgeLoginServiceImpl implements JudgeLoginService{
	
	@Resource
	private IUserDAO iUserDao;
	@Override
	public int loginValidResult(String userName,String userPass) {
		User user=iUserDao.queryUserpasswordByUsername(userName);
		String realPass=user.getPassword();
		System.out.println(realPass);
		System.out.println(userPass);
		if(user==null||!realPass.equals(userPass))
			return -1;
		else return user.getUser_id();
	}
	

}
