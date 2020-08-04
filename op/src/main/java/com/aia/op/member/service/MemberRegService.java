package com.aia.op.member.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aia.op.member.dao.JdbcTemplateMemberDao;
import com.aia.op.member.dao.MemberDao;
import com.aia.op.member.model.Member;
import com.aia.op.member.model.MemberRegRequest;

@Service
public class MemberRegService {

	
	
	@Autowired
	JdbcTemplateMemberDao dao;
	
	public int memberReg(HttpServletRequest request,MemberRegRequest reg) {
		
		
		int result=0;
		
		Member member = reg.toMember();
		
		MultipartFile file = reg.getPhoto();
		
		System.out.println(reg);
		
		if(file != null && !file.isEmpty() && file.getSize() > 0) {
			
			String uri = request.getSession().getServletContext().getInitParameter("memberUploadPath");
			
			String realPath = request.getSession().getServletContext().getRealPath(uri);
			
			String newFileName = System.nanoTime() + "_"+file.getOriginalFilename();
			
			File saveFile = new File(realPath, newFileName);
			
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("저장 완료 :" + newFileName);
			System.out.println("경로 : "+ realPath);
			
			member.setUphoto(newFileName);
			
		} else {
			
			member.setUphoto("default.png");
		}
		
			result = dao.insertMember(member);
		
		
		
		return result;
		
	}
	
	
}
