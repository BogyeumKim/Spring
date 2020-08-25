package com.aia.guest.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.guest.dao.GuestDao;
import com.aia.guest.model.Guest_book;
import com.aia.guest.model.guest_likes;

@Service
public class GuestListService {

	
	
	private GuestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public List<Guest_book> getList(double xx, double yy,int member_radius,int limit){
		dao=template.getMapper(GuestDao.class);
		
		
		
		//System.out.println(dao.selectList(xx, yy, member_radius, limit));
		//return null;
		
		return dao.selectList(xx, yy, member_radius,limit);
		
	}
	
	
}
