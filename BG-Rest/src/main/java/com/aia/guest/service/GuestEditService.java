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
import com.aia.guest.model.Guest_edit;

@Service
public class GuestEditService {

	
	private GuestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int edit(HttpServletRequest request,Guest_edit edit) {
		
		dao=template.getMapper(GuestDao.class);
		
		int result = 0;
		
		
		
		Guest_book gb = edit.editToGb();
		MultipartFile file = edit.getPhoto();
		
		
		
	
	if(file !=null && file.isEmpty() && file.getSize()>0) {
		String uri = "/upload";
		String realPath = request.getSession().getServletContext().getRealPath(uri);
		String newFileName = System.nanoTime() + "_" + file.getOriginalFilename();
		
		File saveFile=new File(realPath,newFileName);//내컴터+나노초파일사진
		try {
			file.transferTo(saveFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 실제저장
		System.out.println(realPath);
		
		gb.setGuest_photo(newFileName); // 새주소경로
		
		 File oldFile = new File(realPath,edit.getOldFile());
		 
		 if(oldFile.exists()) {
			 oldFile.delete();
		 }
		

		}//if끝
	
	else {
		gb.setGuest_photo(edit.getOldFile());
	}
			
		result=dao.editIdx(gb);
		return result;
	}
}
