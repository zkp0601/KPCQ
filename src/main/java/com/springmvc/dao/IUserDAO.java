package com.springmvc.dao;

import com.springmvc.model.User;

/**
 * 作为与数据库User表进行增删改查交互的接口类 <br />
 * 当要对数据库中的 user表 进行操作时，直接调用该类中的相关方法
 * 以下各个方法的实现均在对应的 mapper.xml 文件中
 */
public interface IUserDAO {
	/**
	 * 添加新用户
	 * @param user
	 * @return
	 */
	public void insertUser(User user);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public void UpdateUser(User user);
	
	/**
	 * 根据userId查看用户信息
	 * @param user
	 * @return
	 */
	public void queryUserById(String userId);
	
	/**
	 * 根据ID删除用户信息
	 * @param String id
	 * @return
	 */
	public void deleteUserById(String userId);
}
