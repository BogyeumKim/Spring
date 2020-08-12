package com.aia.guest.dao;

import java.util.List;

import com.aia.guest.model.Guest_Join;
import com.aia.guest.model.Guest_book;

public interface GuestDao {

	
	List<Guest_Join> selectList();

	int insertPost(Guest_book gb);

	Guest_book selectByIdx(int guest_idx);
	
}
