package com.aia.mvc.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.aia.mvc.dao.MemberDao;
import com.aia.mvc.jdbc.ConnectionProvider;

@Service
public class IdCheckService {

	
	@Autowired
	private MemberDao dao;
	
	public String IdChk(String uid) {
		
		String result="N";
		int resultCnt=0;
		Connection conn= null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao=MemberDao.getInstacne();
			
			
			resultCnt = dao.selectId(conn,uid);
			
			if(resultCnt==0) {
				result="Y";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return result;
		
		
	}
	
	
}
