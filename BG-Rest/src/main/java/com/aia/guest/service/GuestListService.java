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
	
	public List<Guest_book> getList(double xx, double yy,int member_radius,int limit, String nick){
		dao=template.getMapper(GuestDao.class);
		
		
		List<Guest_book> list = dao.selectList(xx, yy, member_radius,limit);
		List<guest_likes> likeList = dao.getguest_like(nick); 
		for(int i =0;i<list.size();i++) {
			list.get(i).setCheckLikes(0);
			for(int j =0; j<likeList.size();j++) {
				if(likeList.get(j).getGuestlike_idx()==list.get(i).getGuest_idx()) {
					list.get(i).setCheckLikes(1);
				}
			}
		}
		
		
	System.out.println("사이즈 :"+list.size());
		
		System.out.println(" 서비스에서 리미트보내주는값"+limit);


		return list;
		
		//System.out.println(dao.selectList(xx, yy, member_radius, limit));
		//return null;
		
		//return dao.selectList(xx, yy, member_radius,limit);
		
	}
	
	
}
