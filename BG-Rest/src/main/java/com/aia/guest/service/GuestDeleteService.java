package com.aia.guest.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.guest.dao.GuestDao;
import com.aia.guest.model.Guest_book;

@Service
public class GuestDeleteService {

	
	private GuestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int deletePost(int guest_idx) {
		
		dao=template.getMapper(GuestDao.class);
		return dao.deleteIdx(guest_idx);
	}
}
