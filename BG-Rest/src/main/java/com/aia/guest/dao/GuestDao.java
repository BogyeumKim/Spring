package com.aia.guest.dao;

import java.util.List;

import com.aia.guest.model.Guest_book;
import com.aia.guest.model.Guest_test;
import com.aia.guest.model.guest_comment;

public interface GuestDao {

	
	List<Guest_book> selectList(double xx, double yy, Integer rr,Integer limit);

	int insertPost(Guest_book gb);

	Guest_book selectByIdx(int guest_idx);

	int updatelikeup(int guest_idx);
	
	int updatelikedown(int guest_idx);

	int deleteIdx(int guest_idx);

	int writerCmt(guest_comment cm);

	Guest_test test();
	
	
}
