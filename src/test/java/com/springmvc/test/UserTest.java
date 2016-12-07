package com.springmvc.test;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.springmvc.common.SpringTestCase;
import com.springmvc.dao.IPhotoDAO;
import com.springmvc.dao.IUserDAO;
import com.springmvc.model.Photo;
import com.springmvc.model.User;
import com.springmvc.service.DealReqService;

public class UserTest extends SpringTestCase{
	
	@Resource
	private DealReqService dealReqService;
	
	@Resource
	private IPhotoDAO iPhotodao;
	@Test
	public void test(){
		System.out.println("hello world");
		//iUserdao=new IUserDAO;
		Timestamp ts = new Timestamp(System.currentTimeMillis());  	
		Photo photo=new Photo(2,"d","f",ts);
		//iPhotodao.insertPhoto(photo);
		List<Photo>ph=iPhotodao.queryPhotoByUserId(5);
		for(int i=0;i<ph.size();i++)
			System.out.println(ph.get(i).getUser_id());
		System.out.println("d");
	}
}
