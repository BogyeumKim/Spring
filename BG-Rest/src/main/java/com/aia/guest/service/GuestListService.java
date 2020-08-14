package com.aia.guest.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.guest.dao.GuestDao;
import com.aia.guest.model.Guest_book;

@Service
public class GuestListService {

	
	
	private GuestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public List<Guest_book> getList(double mx, double x,double my,double y, int member_radius){
		dao=template.getMapper(GuestDao.class);
		return dao.selectList(mx, x,my, y, member_radius);
		
	}
	
	
}
