package com.aia.guest.model;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class Guest_book {

	private int guest_idx;
	private String guest_writer;
	private String guest_text;
	private String guest_photo;
	private String guest_date;
	private int guest_like;
	private int guest_hits;
	private Double x;
	private Double y;
	private int member_radius;
	
	
	
	
	
	

	
	public Guest_book(int guest_idx, String guest_writer, String guest_text, String guest_photo, String guest_date,
			int guest_like, int guest_hits, Double x, Double y, int member_radius) {
		this.guest_idx = guest_idx;
		this.guest_writer = guest_writer;
		this.guest_text = guest_text;
		this.guest_photo = guest_photo;
		this.guest_date = guest_date;
		this.guest_like = guest_like;
		this.guest_hits = guest_hits;
		this.x = x;
		this.y = y;
		this.member_radius = member_radius;
	}

	

	public Guest_book() {
	}



	public Guest_book(String guest_writer, String guest_text, Double x, Double y) {
		this(0,guest_writer,guest_text,null,null,0,0,x,y,0);
		
	}
	

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

	public int getGuest_hits() {
		return guest_hits;
	}

	public void setGuest_hits(int guest_hits) {
		this.guest_hits = guest_hits;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}


	public int getMember_radius() {
		return member_radius;
	}


	public void setMember_radius(int member_radius) {
		this.member_radius = member_radius;
	}


	@Override
	public String toString() {
		return "Guest_book [guest_idx=" + guest_idx + ", guest_writer=" + guest_writer + ", guest_text=" + guest_text
				+ ", guest_photo=" + guest_photo + ", guest_date=" + guest_date + ", guest_like=" + guest_like
				+ ", guest_hits=" + guest_hits + ", x=" + x + ", y=" + y + ", member_radius=" + member_radius + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
}
