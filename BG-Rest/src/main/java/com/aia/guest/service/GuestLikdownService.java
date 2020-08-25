package com.aia.guest.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.guest.dao.GuestDao;
import com.aia.guest.model.Guest_book;

@Service
public class GuestLikdownService {

	private GuestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int likedown(int guest_idx, String guest_nick) {
		dao=template.getMapper(GuestDao.class);
		return dao.updatelikedown(guest_idx,guest_nick);
		
	}
	
}
