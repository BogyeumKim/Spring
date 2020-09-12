package com.aia.guest.model;

import org.springframework.stereotype.Repository;

@Repository
public class Guest_count {

	private int post;
	private int cmt;
	public int getPost() {
		return post;
	}
	public void setPost(int post) {
		this.post = post;
	}
	public int getCmt() {
		return cmt;
	}
	public void setCmt(int cmt) {
		this.cmt = cmt;
	}
	@Override
	public String toString() {
		return "Guest_count [post=" + post + ", cmt=" + cmt + "]";
	}
	
	
	
	
	
	
	
}
