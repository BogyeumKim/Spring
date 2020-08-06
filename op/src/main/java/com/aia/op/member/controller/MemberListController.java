package com.aia.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aia.op.member.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	MemberListService service;
	
	@RequestMapping("/member/list")
	public String getList(HttpServletRequest req,Model model) {
		
		model.addAttribute("list",service.getMemberList(req));
		return "/member/ListView";
		
	}
	
}
