package com.aia.guest.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.aia.guest.model.Guest_book;
import com.aia.guest.model.Guest_bookPost;
import com.aia.guest.model.Guest_edit;
import com.aia.guest.model.Guest_test;
import com.aia.guest.model.guest_comment;

public interface GuestDao {

	
	List<Guest_book> selectList(double xx, double yy, int rr,int limit);

	int insertPost(Guest_bookPost gb);

	Guest_book selectByIdx(int guest_idx);

	int updatelikeup(int guest_idx);
	
	int updatelikedown(int guest_idx);

	int deleteIdx(int guest_idx);

	int writerCmt(guest_comment cm);


	int test(double x, double y, int r);

	int editIdx(Guest_book gb);
	
	
}
