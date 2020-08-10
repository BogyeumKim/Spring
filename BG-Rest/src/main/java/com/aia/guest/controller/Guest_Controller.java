package com.aia.guest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.aia.guest.model.Guest_book;
import com.aia.guest.service.GuestListService;
import com.aia.guest.service.GuestWriteService;
import com.sun.org.glassfish.gmbal.ParameterNames;

@RestController
@RequestMapping("/guest_book")
/* @SessionAttributes({"loginInfo","loginInfo"}) */
public class Guest_Controller {

	
	@Autowired
	private GuestListService ListService;
	
	@Autowired
	private GuestWriteService WriteService;
	
	
	
//	 출력
	@GetMapping
	public List<Guest_book> ViewList(){
		return ListService.getList();
	}
	
	
	
	/* @PostMapping("/write") */
	@RequestMapping(value = "/write")
	public int Writing(/* @ModelAttribute("loginInfo.member_idx") int idx, */Model model, Guest_book gb) {
		
//		gb.setGuest_writer(1); 
		return WriteService.boardWriter(gb);
	}
	
	
	
	
	
	
	
	
}
