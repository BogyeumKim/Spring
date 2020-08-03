package com.aia.mvc.service;

import java.io.File;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aia.mvc.dao.MemberDao;
import com.aia.mvc.dto.MemberDBdto;
import com.aia.mvc.dto.MemberRegdto;
import com.aia.mvc.jdbc.ConnectionProvider;

@Service
public class MemberRegService {

	@Autowired
	MemberDao dao;
	
	public int memberReg(MemberRegdto reg,HttpServletRequest request) {
		
		int result = 0;
		
		MemberDBdto member = reg.toMember();
		
		Connection conn;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			
			MultipartFile file = reg.getPhoto();
		
			if(file!=null && !file.isEmpty() && file.getSize()>0) {
				
			
				String uri = request.getSession().getServletContext().getInitParameter("memberUploadPath");
				
				String realPath = request.getSession().getServletContext().getRealPath(uri);
				
				String newFileName = System.nanoTime() + "_" + file.getOriginalFilename();
				
				File saveFile = new File(realPath,newFileName);
				file.transferTo(saveFile);
				System.out.println("저장 완료 " + newFileName);
				
				
				member.setUphoto(newFileName);
				
			}else {
				member.setUphoto("defalult.png");
			}
			
			result=dao.insertMember(conn, member);
			
		}catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
