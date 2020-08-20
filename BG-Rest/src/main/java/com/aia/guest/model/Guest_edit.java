package com.aia.guest.model;

import java.sql.Date;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class Guest_edit {

private int guest_idx;
private String guest_text;
private String oldFile;
private MultipartFile photo;





public int getGuest_idx() {
	return guest_idx;
}





public void setGuest_idx(int guest_idx) {
	this.guest_idx = guest_idx;
}





public String getGuest_text() {
	return guest_text;
}





public void setGuest_text(String guest_text) {
	this.guest_text = guest_text;
}





public String getOldFile() {
	return oldFile;
}





public void setOldFile(String oldFile) {
	this.oldFile = oldFile;
}





public MultipartFile getPhoto() {
	return photo;
}





public void setPhoto(MultipartFile photo) {
	this.photo = photo;
}





public Guest_book editToGb() {
	Guest_book gb = new Guest_book();
	gb.setGuest_idx(guest_idx);
	gb.setGuest_text(guest_text);
	return gb;
}





@Override
public String toString() {
	return "Guest_edit [guest_idx=" + guest_idx + ", guest_text=" + guest_text + ", oldFile=" + oldFile + ", photo="
			+ photo + "]";
}





	
	
}
