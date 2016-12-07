package com.springmvc.dao;


import java.util.List;

import com.springmvc.model.Photo;
import com.springmvc.model.User;

/**
 * 作为与数据库User表进行增删改查交互的接口类 <br />
 * 当要对数据库中的 user表 进行操作时，直接调用该类中的相关方法
 * 以下各个方法的实现均在对应的 mapper.xml 文件中
 */
public interface IPhotoDAO {
	/**
	 * 添加新照片
	 * @param user
	 * @return
	 */
	public  void insertPhoto(Photo photo);
		
	/**
	 * 根据标签查询图片
	 * @param user
	 * @return
	 */
	public Photo queryPhotoByLabels(List<String> label);
	
	/**
	 * 根据id删除图片
	 * @param String id
	 * @return
	 */
	public void deletePhotoById(int id);
	
	/**
	 * 根据用户id查询关注好友图片
	 */
	public List<Photo> queryPhotoByUserId(int user_id);
	
	/**
	 * 根据图片id查询图片
	 */
	public List<Photo> queryPhotoById(int id);
}
