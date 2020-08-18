package com.aia.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.aia.guest.model.Guest_book;
import com.aia.guest.model.Guest_post;
import com.aia.guest.model.guest_comment;
import com.aia.guest.service.GuestDeleteService;
import com.aia.guest.service.GuestLikdownService;
import com.aia.guest.service.GuestListService;
import com.aia.guest.service.GuestViewService;
import com.aia.guest.service.GuestWriteService;
import com.aia.guest.service.GuestlikService;
import com.aia.guest.service.writeCmtService;
import com.sun.org.glassfish.gmbal.ParameterNames;

@RestController
@RequestMapping("/guest_book")
/* @SessionAttributes({"loginInfo","loginInfo"}) */
public class Guest_Controller {

	
	@Autowired
	private GuestListService ListService;
	
	@Autowired
	private GuestWriteService WriteService;
	
	@Autowired
	private GuestViewService viewService;
	
	
	@Autowired
	private GuestlikService likeupService;
	
	@Autowired
	private GuestLikdownService likedownService;
	
	@Autowired
	private GuestDeleteService deleteService;
	
	@Autowired
	private writeCmtService writeCmtService;
	
	
	
	
	
//	 전체 출력
	@GetMapping
	public List<Guest_book> ViewList(@Param("param1") double xx,
			@Param("param2") double yy,
			@Param("param3") int member_radius,
			@Param("param4") int limit){

		return ListService.getList(xx, yy, member_radius,limit);
	}
	
	
	
	
//	글쓰기
	/* @PostMapping("/post") */
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public int Writing(Guest_post postreq,HttpServletRequest request) {
		System.out.println(postreq);
		return WriteService.boardWriter(postreq,request);
	}
	

//한개 출력
	@GetMapping("/{guest_idx}")
	public Guest_book viewgb(@PathVariable("guest_idx") int guest_idx) {
		return viewService.getView(guest_idx);
	}
	
	
// 좋아요증감
	@PutMapping("/plus/{guest_idx}")
	public int likeup(@PathVariable("guest_idx") int guest_idx) {
		return likeupService.likeup(guest_idx);
	}
	
// 좋아요감소
	@PutMapping("/mi/{guest_idx}")
	public int likedown(@PathVariable("guest_idx") int guest_idx) {
		int a =likedownService.likedown(guest_idx);
		return a;
	}
	
	
// 게시글 삭제
	
	@DeleteMapping("/{guest_idx}")
	public int deletegb(@PathVariable("guest_idx") int guest_idx) {
		return deleteService.deletePost(guest_idx);
	}
	
// 댓글쓰기	
	@PostMapping("/cmt")
	public int cmtworite(guest_comment cm) {
		return writeCmtService.writeCmt(cm);
	}
	
	
}
