package com.aia.guest.model;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class Guest_book {

	private int guest_idx;
	private int guest_writer;
	private String guest_text;
	private String guest_photo;
	private Date guest_date;
	private int guest_like;
	private String guest_addr;
	private int guest_hits;
	public int getGuest_idx() {
		return guest_idx;
	}
	public void setGuest_idx(int guest_idx) {
		this.guest_idx = guest_idx;
	}
	public int getGuest_writer() {
		return guest_writer;
	}
	public void setGuest_writer(int guest_writer) {
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
	public Date getGuest_date() {
		return guest_date;
	}
	public void setGuest_date(Date guest_date) {
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
	@Override
	public String toString() {
		return "Guest_book [guest_idx=" + guest_idx + ", guest_writer=" + guest_writer + ", guest_text=" + guest_text
				+ ", guest_photo=" + guest_photo + ", guest_date=" + guest_date + ", guest_like=" + guest_like
				+ ", guest_addr=" + guest_addr + ", guest_hits=" + guest_hits + "]";
	}
	
	
	
	
}
