package com.aia.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aia.mvc.service.IdCheckService;

@Controller
public class IdCheckController {

	
	@Autowired
	IdCheckService idCheckService;
	
	@RequestMapping("/reg/idCheck")
	@ResponseBody
	public String idCheck(@RequestParam("uid") String uid) {
		
		return idCheckService.IdChk(uid);
	}
}
