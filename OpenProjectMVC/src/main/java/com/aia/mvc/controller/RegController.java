package com.aia.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.mvc.dto.MemberRegdto;
import com.aia.mvc.service.MemberRegService;


@Controller
@RequestMapping("/reg/reg")
public class RegController {

	
	@Autowired
	MemberRegService memberRegService;
	
	
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String getMemberRegForm() {
		
		return "reg/regForm";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String getMemberReg(MemberRegdto reg,HttpServletRequest request,Model model) {
		
		model.addAttribute("result",memberRegService.memberReg(reg, request));
		
		return "reg/reg";
	}
}
	
