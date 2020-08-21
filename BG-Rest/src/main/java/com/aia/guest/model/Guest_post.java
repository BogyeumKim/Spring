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
	private String member_img;
	private String guest_addr;
	
	
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
	

	public String getMember_img() {
		return member_img;
	}
	public void setMember_img(String member_img) {
		this.member_img = member_img;
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
	
	
	public String getGuest_addr() {
		return guest_addr;
	}
	public void setGuest_addr(String guest_addr) {
		this.guest_addr = guest_addr;
	}
	
	
	
	public Guest_bookPost togb() {
		Guest_bookPost a = new Guest_bookPost();
		a.setGuest_writer(guest_writer);
		a.setGuest_text(guest_text);
		a.setX(x);
		a.setY(y);
		a.setMember_img(member_img);
		a.setGuest_addr(guest_addr);
		return a;
		
	}
	
	
	@Override
	public String toString() {
		return "Guest_post [guest_writer=" + guest_writer + ", guest_text=" + guest_text + ", x=" + x + ", y=" + y
				+ ", photo=" + photo + ", member_img=" + member_img + ", guest_addr=" + guest_addr + "]";
	}
	
	
	

	
	
	
	
	
	
	
}
