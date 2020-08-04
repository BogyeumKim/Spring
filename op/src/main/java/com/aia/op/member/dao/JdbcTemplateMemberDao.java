package com.aia.op.member.dao;

import com.aia.op.member.model.Member;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateMemberDao {

	
	JdbcTemplate jdbctemplate;
	
	
	public  int insertMember(Member member) {
		int result =0;
		
		String sql = "INSERT INTO project.member (uid, upw, uname, uphoto ) VALUES (?,?,?,?)"; 
		
		
		
		return result;
	}
	
	
}
