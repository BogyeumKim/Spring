package com.aia.mvc.dto;

import org.springframework.web.multipart.MultipartFile;

public class MemberRegdto {


	private String uid;
	private String upw;
	private String uname;
	private MultipartFile photo;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	
	
	public MemberDBdto toMember() {
		return new MemberDBdto(uid,upw,uname);
	}
	
	@Override
	public String toString() {
		return "MemberRegdto [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", photo=" + photo + "]";
	}
	
	
	
	
	
}
