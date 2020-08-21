package com.aia.guest.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.guest.dao.GuestDao;

@Service
public class GuestDeleteService {

	
	private GuestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int deletePost(int guest_idx, String photo, HttpServletRequest req) {
		dao=template.getMapper(GuestDao.class);
		
		String uri = "/upload";
		String realPath= req.getSession().getServletContext().getRealPath(uri);
		
		File file= new File(realPath,photo);
		System.out.println("삭제경로주소 :"+file);
		
		 if(file.exists()) {
			 file.delete();
		 }
		
		
		
		return dao.deleteIdx(guest_idx);
	}
}
