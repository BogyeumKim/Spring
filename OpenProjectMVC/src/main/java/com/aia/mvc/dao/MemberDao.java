package com.aia.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.aia.mvc.dto.MemberDBdto;

@Repository
public class MemberDao {

	
	private MemberDao() {};
	private static MemberDao dao = new MemberDao();
	
	public static MemberDao getInstacne() {
		return dao;
	}
	
	
	public int insertMember(Connection conn, MemberDBdto member) throws SQLException {
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO project.member(uid,upw,uname,uphoto) VALUES ( ?, ?, ?, ? )";
		
		try {
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getUid() );
			pstmt.setString(2, member.getUpw() );
			pstmt.setString(3, member.getUname() );
			pstmt.setString(4, member.getUphoto() );
			
			resultCnt = pstmt.executeUpdate();
		}finally {
			
			if(pstmt!=null) {
				pstmt.close();
			}
			
		}
		
		return resultCnt;
		
		
	} // insert 끝


	public int selectId(Connection conn, String uid) throws SQLException {
		
		int resultCnt = 0;
		
		ResultSet rs;
		PreparedStatement pstmt = null; 
		
		try {
			String sql = "select count(*) from project.member where uid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				resultCnt = rs.getInt(1);
			}
			
			
		}finally {
			if(pstmt!=null) {
				pstmt.close();
			}
		}
		
		
		return resultCnt;
	}


	public MemberDBdto selectIDPW(Connection conn, String uid, String upw) throws SQLException {
	
		PreparedStatement pstmt = null;
		ResultSet rs;
		MemberDBdto member = null;
		
		
		try {
			String sql = "select * from project.member where uid=? and upw=?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, upw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDBdto();
				member.setIdx(rs.getInt("idx"));
				member.setUid(rs.getString("uid"));
				member.setUpw(rs.getString("upw"));
				member.setUname(rs.getString("uname"));
				member.setUphoto(rs.getString("uphoto"));
			}
			
			
		}finally {
			if(pstmt !=null) {
				pstmt.close();
			}
		}
		
		return member;
	}
	

	
	
	
	
}
