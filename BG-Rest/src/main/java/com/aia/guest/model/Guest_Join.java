package com.aia.guest.model;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class Guest_Join {

	private int guest_idx;
	private String guest_writer;
	private String guest_text;
	private String guest_photo;
	private String guest_date;
	private int guest_like;
	private String guest_addr;
	private int guest_hits;
	private int comment_idx;
	private String member_nick;
	private String comment_text;
	private String comment_regdate;
	private int comment_like;
	private int comguest_idx;
	public int getGuest_idx() {
		return guest_idx;
	}
	public void setGuest_idx(int guest_idx) {
		this.guest_idx = guest_idx;
	}
	public String getGuest_writer() {
		return guest_writer;
	}
	public void setGuest_writer(String guest_writer) {
		this.guest_writer = guest_writer;
	}
	public String getGuest_text() {
		return guest_text;
	}
	public void setGuest_text(String guest_text) {
		this.guest_text = guest_text;
	}
	public String getGuest_photo() {
		return guest_photo;
	}
	public void setGuest_photo(String guest_photo) {
		this.guest_photo = guest_photo;
	}
	public String getGuest_date() {
		return guest_date;
	}
	public void setGuest_date(String guest_date) {
		this.guest_date = guest_date;
	}
	public int getGuest_like() {
		return guest_like;
	}
	public void setGuest_like(int guest_like) {
		this.guest_like = guest_like;
	}
	public String getGuest_addr() {
		return guest_addr;
	}
	public void setGuest_addr(String guest_addr) {
		this.guest_addr = guest_addr;
	}
	public int getGuest_hits() {
		return guest_hits;
	}
	public void setGuest_hits(int guest_hits) {
		this.guest_hits = guest_hits;
	}
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
		return "Guest_Join [guest_idx=" + guest_idx + ", guest_writer=" + guest_writer + ", guest_text=" + guest_text
				+ ", guest_photo=" + guest_photo + ", guest_date=" + guest_date + ", guest_like=" + guest_like
				+ ", guest_addr=" + guest_addr + ", guest_hits=" + guest_hits + ", comment_idx=" + comment_idx
				+ ", member_nick=" + member_nick + ", comment_text=" + comment_text + ", comment_regdate="
				+ comment_regdate + ", comment_like=" + comment_like + ", comguest_idx=" + comguest_idx + "]";
	}
	
	
	
	
}
