package com.aia.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aia.op.member.dao.JdbcTemplateMemberDao;
import com.aia.op.member.dao.MemberDao;
import com.aia.op.member.dao.MemberDaoInterface;
import com.aia.op.member.dao.MybatisMemberDao;
import com.aia.op.member.model.Member;
import com.aia.op.member.model.MemberRegRequest;

@Service
public class MemberRegService {

	
	
	/*
	 * @Autowired JdbcTemplateMemberDao dao;
	 */
	
	/*
	 * @Autowired MybatisMemberDao dao;
	 */
	
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	
	public int memberReg(HttpServletRequest request,MemberRegRequest reg) throws SQLException {
		
		
		
		dao = sessionTemplate.getMapper(MemberDaoInterface.class);
		
		
		int result=0;
		
		Member member = reg.toMember();
		
		
		System.out.println("입력전 IDX =>>>>>>>>>>>" + member.getIdx());
		
		
		
		
		
		
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
		
			System.out.println("입력후 IDX =>>>>>>>>>>>" + member.getIdx());
		
		return result;
		
	}
	
	
}
