package com.springmvc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springmvc.model.Photo;

public interface PictureService {
   public String loadPictureForHomepage(int user_id);
   public String uploadPicture(int user_id,MultipartFile myfile,String realpath,String description);
}
