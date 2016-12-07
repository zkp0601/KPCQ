package com.springmvc.model;

import java.sql.Timestamp;

public class Follow {
		private int id;
		private int follower_id;
		private int followed_id;
		private Timestamp date;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getFollower_id() {
			return follower_id;
		}
		public void setFollower_id(int follower_id) {
			this.follower_id = follower_id;
		}
		public int getFollowed_id() {
			return followed_id;
		}
		public void setFollowed_id(int followed_id) {
			this.followed_id = followed_id;
		}
		public Timestamp getDate() {
			return date;
		}
		public void setDate(Timestamp date) {
			this.date = date;
		}
		
}
