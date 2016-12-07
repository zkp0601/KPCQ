package com.springmvc.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.model.User;
import com.springmvc.service.RegisterService;

@Controller
@RequestMapping(value={"/register"})
public class RegisterController extends BaseController{
  @Resource 
  private RegisterService registerservice;

	/** 返回 register.jsp 页面 */
	@RequestMapping(value={""})
	public String index(){
		return "register";
	}
	
	
  @RequestMapping(value={"/register_submit"})
  @ResponseBody
  public String registerUserResult(HttpServletRequest req){
	  String userName=req.getParameter("userName");
	  String userPassword=req.getParameter("userPass");
	  String userEmail=req.getParameter("userEmail");
	  User user=new User(userName,userPassword,userEmail);
	  return registerservice.registerUser(user);	  
  }
}
