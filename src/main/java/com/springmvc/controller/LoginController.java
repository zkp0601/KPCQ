package com.springmvc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.common.Constants;
import com.springmvc.service.JudgeLoginService;

@Controller
@RequestMapping(value={"/login"})
public class LoginController extends BaseController{
	
	@Resource
	private JudgeLoginService judgeLoginService;
	
	/** 返回 login.jsp 页面 */
	@RequestMapping(value={""})
	public String index(){
		return "login";
	}
	
	
	@RequestMapping(value={"/validate"})
	@ResponseBody
	public String loginResult(HttpServletRequest req){
		String userName=req.getParameter("userName");
		String userPass=req.getParameter("userPassword");
		System.out.println("userName:"+userName);
		int loginResult =  judgeLoginService.loginValidResult(userName, userPass);
		System.out.println(loginResult);
		if(loginResult!=-1){
			req.getSession().setAttribute(Constants.SESSION_TOKEN, "loginsadas");
			req.getSession().setAttribute("user_id",loginResult);
		}
		
		return "true";
	}
}
