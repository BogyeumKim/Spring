package com.aia.guest.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.guest.dao.GuestDao;

@Service
public class CommentDeleteService {

	
	private GuestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int delcmt(int comment_idx) {
		dao=template.getMapper(GuestDao.class);
		
		
		return dao.deleteCmtIdx(comment_idx);
	}
}
