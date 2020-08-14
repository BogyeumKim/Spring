package com.aia.guest.dao;

import java.util.List;

import com.aia.guest.model.Guest_book;

public interface GuestDao {

	
	List<Guest_book> selectList(double mx, double x,double my,double y, int member_radius);

	int insertPost(Guest_book gb);

	Guest_book selectByIdx(int guest_idx);

	int updatelikeup(int guest_idx);
	
	int updatelikedown(int guest_idx);
	
}
