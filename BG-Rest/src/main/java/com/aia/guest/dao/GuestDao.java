package com.aia.guest.dao;

import java.util.List;

import com.aia.guest.model.Guest_book;

public interface GuestDao {

	
	List<Guest_book> selectList();

	int insertPost(Guest_book gb);

	Guest_book selectByIdx(int guest_idx);

	Guest_book updatehits(int guest_idx);
	
}
