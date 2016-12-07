package com.springmvc.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.springmvc.dao.IPhotoDAO;
import com.springmvc.model.Photo;
import com.springmvc.service.PictureService;
@Service
@Configuration
public class PictureServiceImpl implements PictureService{
    @Resource
    private IPhotoDAO iPhotodao;
    
	@Override
	public String loadPictureForHomepage(int user_id) {
		
		List<Photo> ph= iPhotodao.queryPhotoByUserId(user_id);
			return JSON.toJSONString(ph);
	}

	@Override
	public String uploadPicture(int user_id,MultipartFile myfile,String realpath,String description) {
		String originalFilename = null;
		//存放结果的HashMap
		HashMap<String,String>result=new HashMap<String,String>();
			if(myfile.isEmpty()){
				result.put("result", "false");
				result.put("message", "请选择文件后再上传");
				return JSON.toJSONString(result);
			}else{
				originalFilename = myfile.getOriginalFilename();
				System.out.println("文件原名: " + originalFilename);
				System.out.println("文件名称: " + myfile.getName());
				System.out.println("文件长度: " + myfile.getSize());
				System.out.println("文件类型: " + myfile.getContentType());
				System.out.println("========================================");
				try {
				
					FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realpath, originalFilename));
				} catch (IOException e) {
					e.printStackTrace();
					result.put("result", "false");
					result.put("message", "文件上传失败");
					return JSON.toJSONString(result);
				}
			}
		String filepath=realpath+"/"+ originalFilename;
        System.out.println("filepath:"+filepath);	
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Photo photo=new Photo(user_id,"upload/"+originalFilename,description,ts);
        iPhotodao.insertPhoto(photo);
        result.put("result", "true");
        return JSON.toJSONString(result);	
	}

}
