package com.aia.op.member.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.aia.op.member.model.Member;

public interface MemberDaoInterface {

	
	
	public Member selectByIdpw( String uid, String pw);
}
