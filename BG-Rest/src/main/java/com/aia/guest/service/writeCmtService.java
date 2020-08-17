package com.aia.guest.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.guest.dao.GuestDao;
import com.aia.guest.model.guest_comment;

@Service
public class writeCmtService {

	
	GuestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int writeCmt(guest_comment cm) {
		dao=template.getMapper(GuestDao.class);
		
		return dao.writerCmt(cm);
	}
}
