package com.aia.guest.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.guest.dao.GuestDao;

@Service
public class CmtEditService {

	
	private GuestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int editcmt(String comment_text) {
		
		dao=template.getMapper(GuestDao.class);
		return dao.editTextCmt(comment_text);
	}
}
