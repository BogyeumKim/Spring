package com.aia.guest.service;


import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aia.guest.dao.GuestDao;
import com.aia.guest.model.Guest_book;
import com.aia.guest.model.Guest_post;

@Service
public class GuestWriteService {

	
	private GuestDao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	public int boardWriter(Guest_post postreq, HttpServletRequest request) {
		
		Guest_book gb = postreq.toGuest();
		
		dao=template.getMapper(GuestDao.class);
		
		int result=0;
		try {
		MultipartFile file = postreq.getPhoto();
		
		if(file != null && !file.isEmpty() && file.getSize() > 0) {
			
			String uri = "/upload";
			String realPath = request.getSession().getServletContext().getRealPath(uri);
			String newFileName = System.nanoTime() + "_" + file.getOriginalFilename();
			File saveFile=new File(realPath,newFileName);
			file.transferTo(saveFile);
			System.out.println(realPath);
			gb.setGuest_photo(newFileName);
			
			} 
		
		
			 else { 
				 gb.setGuest_photo(null); 
			 }
					 
			
			result=dao.insertPost(gb);
		
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
	
	
}
