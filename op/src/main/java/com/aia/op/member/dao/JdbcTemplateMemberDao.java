package com.aia.op.member.dao;

import com.aia.op.member.model.Member;

import java.sql.SQLException;
import java.util.List;

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

	public int selectTotalCount() throws SQLException {
		return jdbctemplate.queryForObject("select count(*) from project.member", Integer.class);
	}
	
public List<Member> selectList(int startRow, int count) throws SQLException {
		
		
//		List<Member> memberList = new ArrayList<Member>();
//		String sql = "select * from project.member order by uname limit ?, ?";
//		memberList = jdbcTemplate.query(sql,new Object[] {startRow, count}, new MemberRowMapper());
//		return memberList;
		
		return jdbctemplate.query("select * from project.member order by uname limit ?, ?",new Object[] {startRow, count}, new MemberRowMapper());
		
		
		
	}


	
	
	public int checkId(String uid) {
		
		String sql = "select count(*) from project.member where uid=?";
		
		return jdbctemplate.queryForObject(sql, Integer.class,uid);
		
		
	}
	
	
}
