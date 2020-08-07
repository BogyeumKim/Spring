package com.aia.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.member.model.Member;
import com.aia.member.model.MemberEditRequest;
import com.aia.member.model.MemberRegRequest;
import com.aia.member.service.MemberEditService;
import com.aia.member.service.MemberListService;
import com.aia.member.service.MemberRegService;
import com.aia.member.service.MemberViewService;

@RestController
@RequestMapping("/members") // 겟방식이라면 /members?pageNum=&cnt=10
public class MemberRestController {

	@Autowired
	MemberListService listService;
	
	
	@Autowired
	MemberRegService regsSrvice;
	
	@Autowired
	MemberViewService viewService;
	
	
	@Autowired
	MemberEditService editService;
	
	
	
	//회원의 리스트 : Json 으로 응답
	@GetMapping		// GET , 경로 : /members
	public List<Member> getMemberList(){
		
	
		return listService.getMemberList();
	}
	
	// 회원 가입
	@PostMapping	// POST  , 경로 : /members
	public int reg(MemberRegRequest regRequest,HttpServletRequest request) {
		
		return regsSrvice.regMember(regRequest,request);
	}
	
	
	
	// 회원 한명 정보 출력
	@GetMapping("/{idx}")
	public Member getMember(@PathVariable("idx") int idx) {
		
		return viewService.getMember(idx);
	}
	
	
	
	
	// 회원 한명 정보 수정
	
	//@PutMapping("/{idx}") // Http리퀘스트받아온건 절대경로때문에 받아온거라고함
	@PostMapping("/{idx}")
	public int edit(@PathVariable("idx") int idx, HttpServletRequest request, MemberEditRequest editRequest) {
		
		
		editRequest.setIdx(idx); // 먼저 idx보내야함 
		
		return editService.editMember(editRequest, request);
	}
	
	
	// 회원 삭제
	@DeleteMapping("/{idx}")
	public int delete() {
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
}
