package com.springmvc.controller;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.service.DealReqService;

@Controller
@RequestMapping(value={"/index"})
public class IndexController extends BaseController{
	
	@Resource
	private DealReqService dealReqService;
	
	/** 返回 index.jsp 页面 */
	@RequestMapping(value={"/", ""})
	public String index(){
		return "index";
	}
	
	/** 返回相关数据， 非页面 */
	@RequestMapping("/getData")
	@ResponseBody
	public String getData(){
		dealReqService.dealReq(null);
		return "success";
	}
}
