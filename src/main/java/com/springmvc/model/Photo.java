package com.springmvc.model;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 图片表
 * @author ophirlin
 *
 */
public class Photo implements Serializable{

	private static final long serialVersionUID = 1L;
	private	int id;
	private	int user_id;
	private	String photo_url;
	private	Timestamp date;
	private	String description;
	public	Photo(){
			
		}
	public	Photo(int user_id,String photo_url,String description,Timestamp date){
			this.setUser_id(user_id);
			this.setPhoto_url(photo_url);
			this.setDescription(description);
			this.setDate(date);
		}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getPhoto_url() {
		return photo_url;
	}
	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
		
		
}
