package com.aia.op.member.dao;

import com.aia.op.member.model.Member;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class JdbcTemplateMemberDao {

	@Inject
	JdbcTemplate jdbctemplate;
	
	
	public  int insertMember(Member member) {
		int result =0;
		
		String sql = "INSERT INTO project.member (uid, upw, uname, uphoto ) VALUES (?,?,?,?)"; 
		
		result = jdbctemplate.update(sql, member.getUid(),member.getUpw(),member.getUname(),member.getUphoto());
		
		return result;
	}


	public int checkId(String uid) {
		
		String sql = "select count(*) from project.member where uid=?";
		
		return jdbctemplate.queryForObject(sql, Integer.class,uid);
		
		
	}
	
	
}
