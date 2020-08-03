package com.aia.mvc.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.mvc.dto.MemberLogindto;
import com.aia.mvc.service.LoginService;

@Controller
@RequestMapping("/login/login2")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String loginForm() {
		return "login/loginForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(MemberLogindto login,HttpSession session, HttpServletResponse response,Model model) {
		
		model.addAttribute("result",loginService.login(login, response, session));
		
		return "login/login";
		
	}
	
	
	
}
