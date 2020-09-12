package com.aia.guest.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.guest.dao.GuestDao;
import com.aia.guest.model.Guest_book;
import com.aia.guest.model.Guest_count;

@Service
public class CountService {

	
	private GuestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public Guest_count Mycount(String guest_nick) {
		
		dao=template.getMapper(GuestDao.class);
		return dao.mycount(guest_nick);
	}
}
