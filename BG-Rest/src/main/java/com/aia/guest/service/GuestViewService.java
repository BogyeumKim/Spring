package com.aia.guest.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.guest.dao.GuestDao;
import com.aia.guest.model.Guest_book;
import com.aia.guest.model.guest_likes;

@Service
public class GuestViewService {

	
	private GuestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public Guest_book getView(int guest_idx, String nick) {
		
		dao=template.getMapper(GuestDao.class);
		

		Guest_book list = dao.selectByIdx(guest_idx);
		List<guest_likes> likeList = dao.getguest_like(nick); 
		
			list.setCheckLikes(0);
			for(int j =0; j<likeList.size();j++) {
				if(likeList.get(j).getGuestlike_idx()==list.getGuest_idx()) {
					list.setCheckLikes(1);
				}
			}
		


		return list;
	}
}
