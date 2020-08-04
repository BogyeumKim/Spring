package com.aia.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.op.member.model.MemberRegRequest;
import com.aia.op.member.service.MemberRegService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	@Autowired
	MemberRegService regService;

	@RequestMapping(method = RequestMethod.GET)
	public String getRegForm() {
		
		return "member/memberRegForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String getRegService(MemberRegRequest reg, HttpServletRequest request, Model model) {
		
		
		System.out.println("컨트롤러 : "+reg);
		
		model.addAttribute("result",regService.memberReg(request, reg));
		
		
		return "member/memberReg";
	}
	
}
