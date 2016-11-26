package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"/login"})
public class LoginController extends BaseController{
	
	/** 返回 login.jsp 页面 */
	@RequestMapping(value={""})
	public String index(){
		return "login";
	}
}
