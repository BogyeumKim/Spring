package com.aia.guest.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.aia.guest.model.Guest_book;
import com.aia.guest.model.Guest_edit;
import com.aia.guest.model.Guest_test;
import com.aia.guest.model.guest_comment;
import com.aia.guest.model.guest_likes;

public interface GuestDao {

	
	List<Guest_book> selectList(double xx, double yy, int rr,int limit);

	int insertPost(Guest_book gb);

	Guest_book selectByIdx(int guest_idx);

	int updatelikeup(guest_likes lk); // guest_like Table eidx비교후 check값 0,1구분 
	
	int updatelikedown(int guest_idx, String guest_nick); //guest_like Table idx비교후 check값 0,1구분 

	int likeup(int guest_idx); // guest_book Table like증감
	
	int likedown(int guest_idx); // guest_book Table like감소
	
	int deleteIdx(int guest_idx);

	int writerCmt(guest_comment cm);


	int test(double x, double y, int r);

	int editIdx(Guest_book gb);
	
	
	List<guest_likes> getguest_like(String nick);
	
	
	List<Guest_book> selectSessionList(String nick);

	guest_comment selectCmtIdx(int comment_idx);

	int deleteCmtIdx(int comment_idx);

	
}
