package com.aia.guest.model;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class guest_comment {

	
	private int comment_idx;
	private int member_idx;
	private String comment_text;
	private Date comment_regdate;
	private int comment_like;
	private int guest_idx;
	public int getComment_idx() {
		return comment_idx;
	}
	public void setComment_idx(int comment_idx) {
		this.comment_idx = comment_idx;
	}
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	public Date getComment_regdate() {
		return comment_regdate;
	}
	public void setComment_regdate(Date comment_regdate) {
		this.comment_regdate = comment_regdate;
	}
	public int getComment_like() {
		return comment_like;
	}
	public void setComment_like(int comment_like) {
		this.comment_like = comment_like;
	}
	public int getGuest_idx() {
		return guest_idx;
	}
	public void setGuest_idx(int guest_idx) {
		this.guest_idx = guest_idx;
	}
	@Override
	public String toString() {
		return "guest_comment [comment_idx=" + comment_idx + ", member_idx=" + member_idx + ", comment_text="
				+ comment_text + ", comment_regdate=" + comment_regdate + ", comment_like=" + comment_like
				+ ", guest_idx=" + guest_idx + "]";
	}
	
	
	
}
