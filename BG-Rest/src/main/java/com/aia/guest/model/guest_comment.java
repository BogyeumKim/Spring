package com.aia.guest.model;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class guest_comment {

	
	private int comment_idx;
	private String member_nick;
	private String comment_text;
	private String comment_regdate;
	private int comment_like;
	private int comguest_idx;
	
	public int getComment_idx() {
		return comment_idx;
	}
	public void setComment_idx(int comment_idx) {
		this.comment_idx = comment_idx;
	}
	public String getMember_nick() {
		return member_nick;
	}
	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	public String getComment_regdate() {
		return comment_regdate;
	}
	public void setComment_regdate(String comment_regdate) {
		this.comment_regdate = comment_regdate;
	}
	public int getComment_like() {
		return comment_like;
	}
	public void setComment_like(int comment_like) {
		this.comment_like = comment_like;
	}
	public int getComguest_idx() {
		return comguest_idx;
	}
	public void setComguest_idx(int comguest_idx) {
		this.comguest_idx = comguest_idx;
	}
	@Override
	public String toString() {
		return "guest_comment [comment_idx=" + comment_idx + ", member_nick=" + member_nick + ", comment_text="
				+ comment_text + ", comment_regdate=" + comment_regdate + ", comment_like=" + comment_like
				+ ", comguest_idx=" + comguest_idx + "]";
	}
	
	
	
	
	
	
	
}
