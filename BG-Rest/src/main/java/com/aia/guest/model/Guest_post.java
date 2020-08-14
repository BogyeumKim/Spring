package com.aia.guest.model;

import java.sql.Date;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class Guest_post {

	private String guest_writer;
	private String guest_text;
	private Double x;
	private Double y;
	private MultipartFile photo;
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
	
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	
	public Guest_book toGuest() {
		return new Guest_book(guest_writer,guest_text,x,y);
	}
	
	

	@Override
	public String toString() {
		return "Guest_post [guest_writer=" + guest_writer + ", guest_text=" + guest_text + ", x=" + x + ", y=" + y
				+ ", photo=" + photo + "]";
	}
	
	
	
	
	
	
	
	
	
}
