package com.aia.guest.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.guest.dao.GuestDao;
import com.aia.guest.model.guest_comment;

@Service
public class CmtViewService {

	
	private GuestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public guest_comment getcmt(int comment_idx) {
		
		dao=template.getMapper(GuestDao.class);
		return dao.selectCmtIdx(comment_idx);
	}
}
