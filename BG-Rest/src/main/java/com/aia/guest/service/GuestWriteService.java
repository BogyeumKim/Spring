package com.aia.guest.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.guest.dao.GuestDao;
import com.aia.guest.model.Guest_book;

@Service
public class GuestWriteService {

	
	private GuestDao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	public int boardWriter(Guest_book gb) {
		dao=template.getMapper(GuestDao.class);
		return dao.insertPost(gb);
	}
	
	
}
