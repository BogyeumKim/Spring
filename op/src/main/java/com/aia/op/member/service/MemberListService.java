package com.aia.op.member.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.aia.op.member.dao.MemberDaoInterface;
import com.aia.op.member.model.Member;

@Service
public class MemberListService {

	
	private MemberDaoInterface dao;
	
	@Inject
	private SqlSessionTemplate template;
	
	
	public List<Member> getMemberList(HttpServletRequest request){
		
		dao=template.getMapper(MemberDaoInterface.class);
		
		
		List<Member> members = new ArrayList<Member>();
		
		
		return members=dao.selectList();
		
		
		
		
	}
	
}
