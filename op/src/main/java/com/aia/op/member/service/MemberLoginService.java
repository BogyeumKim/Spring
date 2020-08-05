package com.aia.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.op.member.dao.MemberDao;
import com.aia.op.member.dao.MemberDaoInterface;
import com.aia.op.member.dao.MybatisMemberDao;
import com.aia.op.member.model.LoginInfo;
import com.aia.op.member.model.LoginRequest;
import com.aia.op.member.model.Member;

@Service
public class MemberLoginService {
	
	
	private MemberDaoInterface dao;
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public String login(
			LoginRequest loginRequest, 
			HttpSession session, 
			HttpServletResponse response) {

		
		
		// interface의 Mapper 객체 생성
		
		dao = sessionTemplate.getMapper(MemberDaoInterface.class);
		
		String loginResult = "";


		// 로그인 처리
		Member member = null;

		member = dao.selectByIdpw(loginRequest.getUid(), loginRequest.getUpw());

		System.out.println("LoginService Member : " + member);

		if (member != null) {

			LoginInfo loginInfo = new LoginInfo(member.getUid(), member.getUname(), member.getUphoto());

			session.setAttribute("loginInfo", loginInfo);


			// 로그인 이 필요했던 이전 페이지
			loginResult = "<script>" + "alert('로그인되었습니다.');" + "location.href='" + loginRequest.getRedirecUri() + "'" + "</script>";

		} else {
			loginResult = "<script>" + "alert('아이디 또는 비밀번호가 틀립니다.');" + "history.go(-1);" + "</script>";
		}

		return loginResult;

	}

}
