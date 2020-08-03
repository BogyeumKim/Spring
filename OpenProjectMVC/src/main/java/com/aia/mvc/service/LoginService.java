package com.aia.mvc.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mvc.dao.MemberDao;
import com.aia.mvc.dto.LoginInfo;
import com.aia.mvc.dto.MemberDBdto;
import com.aia.mvc.dto.MemberLogindto;
import com.aia.mvc.jdbc.ConnectionProvider;

@Service
public class LoginService {

	@Autowired
	MemberDao dao;
	
	public String login(MemberLogindto login,HttpServletResponse response,HttpSession session) {
		
		String loginResult = "";
		
		Connection conn = null;
		
		MemberDBdto member = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			member = dao.selectIDPW(conn,login.getUid(),login.getUpw());
			
			System.out.println("접속한 멤버 : " + member);
			
			if(member !=null) {
				
				LoginInfo loginInfo = new LoginInfo(member.getUid(),member.getUname(),member.getUphoto());
				
				session.setAttribute("loginInfo", loginInfo);
				
				
				loginResult = "<script>" + "alert('로그인되었습니다.');" + "location.href='" + login.getRedirecUri() + "'" + "</script>";

			} else {
				loginResult = "<script>" + "alert('아이디 또는 비밀번호가 틀립니다.');" + "history.go(-1);" + "</script>";
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return loginResult;
	}
	
	
}
