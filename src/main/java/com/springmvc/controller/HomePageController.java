package com.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.dao.IPhotoDAO;
import com.springmvc.service.PictureService;


@Controller
@RequestMapping (value={"/homepage"})
public class HomePageController extends BaseController{

	 @Resource 
	  private PictureService pictureService;
	 
	/** 返回 homepage.jsp 页面 */
	@RequestMapping(value={""})
	public String index(){
		return "homepage";
	}
	
	/**上传图片*/
	@RequestMapping(value={"/uploadpicture"})
	@ResponseBody
	public String uploadPicture(@RequestParam("file") MultipartFile myfile, HttpServletRequest request){
	    int user_id=(int) request.getSession().getAttribute("user_id");
		System.out.println("收到用户[" + user_id + "]的文件上传请求");
		//这里实现文件上传操作用的是commons.io.FileUtils类,它会自动判断/upload是否存在,不存在会自动创建
		String realPath = request.getSession().getServletContext().getRealPath("/upload");
		//得到前端传来的照片description
		String description=request.getParameter("description");
		System.out.println(description);
	      return  pictureService.uploadPicture(user_id, myfile, realPath,description);
	}
	
	
	
    /**加载好友图片*/
	@RequestMapping(value={"/showpicture"})
	@ResponseBody
	public String loadPictureForHomePage(HttpServletRequest req){
		int user_id=(int) req.getSession().getAttribute("user_id");
		System.out.println(pictureService.loadPictureForHomepage(user_id));
		return pictureService.loadPictureForHomepage(user_id);

	}
}
