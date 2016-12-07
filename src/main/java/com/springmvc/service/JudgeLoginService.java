package com.springmvc.service;


public interface JudgeLoginService {
	/**
	 * 
	 * @param userName
	 * @param userPass
	 * @return
	 */
	public int loginValidResult(String userName,String userPass);
}
