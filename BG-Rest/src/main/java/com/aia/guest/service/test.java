package com.aia.guest.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.guest.dao.GuestDao;
import com.aia.guest.model.Guest_book;
import com.aia.guest.model.Guest_test;

@Service
public class test {

	
	private GuestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int atest(double x, double y, int r) {
		
		dao=template.getMapper(GuestDao.class);
		return dao.test(x,y,r);
	}
	


}
