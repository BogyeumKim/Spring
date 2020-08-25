package com.aia.guest.model;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class guest_likes {

	private int guestlike_idx;
	private String guestlike_nick;
	public int getGuestlike_idx() {
		return guestlike_idx;
	}
	public void setGuestlike_idx(int guestlike_idx) {
		this.guestlike_idx = guestlike_idx;
	}
	public String getGuestlike_nick() {
		return guestlike_nick;
	}
	public void setGuestlike_nick(String guestlike_nick) {
		this.guestlike_nick = guestlike_nick;
	}
	@Override
	public String toString() {
		return "guest_likes [guestlike_idx=" + guestlike_idx + ", guestlike_nick=" + guestlike_nick + "]";
	}
	

	
	
	
	
	
	
	
	
}
