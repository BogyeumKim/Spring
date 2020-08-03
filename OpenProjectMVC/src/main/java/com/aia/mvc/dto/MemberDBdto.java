package com.aia.mvc.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class MemberDBdto {

	
	private int idx;
	private String uid;
	private String upw;
	private String uname;
	private String uphoto;
	private Date regdate;  //util이 아니라 sql로 받기 
	
	
	
	
	public MemberDBdto(String uid, String upw, String uname) {
		this.idx = 0;
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uphoto = null;
		this.regdate = null;
	}
	
	
	public MemberDBdto() {
		
	};
	
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
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
	public String getUphoto() {
		return uphoto;
	}
	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
	public java.util.Date getTodate(){ 
		return new java.util.Date(regdate.getTime());
		
	}
	
	
	@Override
	public String toString() {
		return "MemberDBdto [idx=" + idx + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uphoto=" + uphoto
				+ ", regdate=" + regdate + "]";
	}
	
	
	
	
	
}
