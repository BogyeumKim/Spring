package com.aia.guest.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.guest.dao.GuestDao;
import com.aia.guest.model.Guest_book;
import com.aia.guest.model.guest_likes;

@Service
public class GuestlikService {

	private GuestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int likeup(guest_likes lk) {
		dao=template.getMapper(GuestDao.class);
		return dao.updatelikeup(lk);
		
	}
	
	public int likeupcount(int guest_idx) {
		dao=template.getMapper(GuestDao.class);
		return dao.likeup(guest_idx);
	}
	
	
}
