package com.aia.mm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.mm.model.Member;
import com.aia.mm.model.MemberEditRequest;
import com.aia.mm.model.MemberRegRequest;
import com.aia.mm.service.MemberDeleteService;
import com.aia.mm.service.MemberEditService;
import com.aia.mm.service.MemberListService;
import com.aia.mm.service.MemberRegService;
import com.aia.mm.service.MemberViewService;

@RestController
@RequestMapping("/members") // 겟방식이라면 /members?pageNum=&cnt=10
public class MemberRestController {

	@Autowired
	private MemberListService listService;
	
	
	@Autowired
	private MemberRegService regsSrvice;
	
	@Autowired
	private MemberViewService viewService;
	
	
	@Autowired
	private MemberEditService editService;
	
	@Autowired
	private MemberDeleteService deleteService;
	
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
	public int delete(@PathVariable("idx") int idx) {
		
		return deleteService.deleteMember(idx);
	}
	
	
	
	
	
	
	
	
	
	
	
}
