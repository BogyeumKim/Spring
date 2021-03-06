package com.aia.guest.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.aia.guest.model.Guest_book;
import com.aia.guest.model.Guest_count;
import com.aia.guest.model.Guest_edit;
import com.aia.guest.model.Guest_post;
import com.aia.guest.model.Guest_test;
import com.aia.guest.model.guest_comment;
import com.aia.guest.model.guest_likes;
import com.aia.guest.service.CmtEditService;
import com.aia.guest.service.CmtViewService;
import com.aia.guest.service.CommentDeleteService;
import com.aia.guest.service.CountService;
import com.aia.guest.service.GuestDeleteService;
import com.aia.guest.service.GuestEditService;
import com.aia.guest.service.GuestHitsUpService;
import com.aia.guest.service.GuestLikdownService;
import com.aia.guest.service.GuestListService;
import com.aia.guest.service.GuestViewService;
import com.aia.guest.service.GuestWriteService;
import com.aia.guest.service.GuestlikService;
import com.aia.guest.service.SessionViewService;
import com.aia.guest.service.writeCmtService;
import com.mysql.cj.Session;
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
	
	@Autowired
	private com.aia.guest.service.test testservice;
	
	@Autowired
	private GuestEditService editservice;
	
	@Autowired
	private SessionViewService sessionViewService;
	
	@Autowired
	private CmtViewService cmtViewService;
	
	@Autowired
	private CommentDeleteService cmtDeleteServcie;
	
	@Autowired
	private CmtEditService cmteditService;
	
	@Autowired
	private GuestHitsUpService hitService;
	
	@Autowired
	private CountService countService;
	
	
//	 전체 출력
	@CrossOrigin
	@GetMapping
	public List<Guest_book> ViewList(@Param("param1") double xx,
			@Param("param2") double yy,
			@Param("param3") int member_radius,
			@Param("param4") int limit,
			@RequestParam("nick") String nick){
		
		return ListService.getList(xx, yy, member_radius,limit,nick);
	}
	
	
	
	
//	글쓰기
//	@RequestMapping(value = "/post", method = RequestMethod.POST)
	@CrossOrigin
	@PostMapping("/post")
	public int Writing(Guest_post postreq,HttpServletRequest request) {
		System.out.println(postreq);
		return WriteService.boardWriter(postreq,request);
	}
	

//한개 출력
	@CrossOrigin
	@GetMapping("/{guest_idx}")
	public Guest_book viewgb(@PathVariable("guest_idx") int guest_idx,
			@RequestParam("nick") String nick,HttpServletRequest req,HttpServletResponse res,HttpSession session) {
		
		
		///////// 세션으로 로긴증감처리
		/*
		 * long update_time=0;
		 * 
		 * if(session.getAttribute("update_time"+guest_idx)!=null) {
		 * update_time=(long)session.getAttribute("update_time"+guest_idx); }
		 * 
		 * long current_time=System.currentTimeMillis();
		 * 
		 * if(current_time - update_time>24*60*601000) { int result =
		 * hitService.Hitsup(guest_idx); session.setAttribute("update_time"+guest_idx,
		 * current_time); long test = (long) (current_time - update_time); }
		 */
		return viewService.getView(guest_idx,nick);
	}
	
	
// 조회수증감
	@CrossOrigin
	@PutMapping("/hitsup/{guest_idx}")
	public int hitsup(@PathVariable("guest_idx") int guest_idx,HttpServletRequest req,HttpServletResponse res) {
			///////// 쿠키로 로긴증감처리
		Cookie[] cookies = req.getCookies();
		String idxNo=Integer.toString(guest_idx);
		Cookie viewCookie= null;
		
		if(cookies !=null && cookies.length>0) {
			for(int i=0; i< cookies.length; i++) {
				if(cookies[i].getName().equals("cookie"+guest_idx)) {
					viewCookie = cookies[i];
				}
			}
		}
		
		if(viewCookie==null) {
			System.out.println("쿠키없음 생성");
			Cookie newCookie = new Cookie("cookie"+guest_idx,idxNo);
			
			res.addCookie(newCookie);
			
			return hitService.Hitsup(guest_idx);
			
		}else {
			String value = viewCookie.getValue();
			System.out.println("쿠키있음"+value);
		}
		return guest_idx;
	}
	
// 좋아요 1인당 1개 증감 
	@CrossOrigin
	@PostMapping("/plus/{guest_idx}")
	public int likeup(guest_likes lk,@PathVariable("guest_idx") int guest_idx,@RequestBody String guest_nick) {
		lk.setGuestlike_idx(guest_idx);
		lk.setGuestlike_nick(guest_nick);
		//System.out.println(lk.getGuestlike_idx());
		//System.out.println(lk.getGuestlike_nick());
		return likeupService.likeup(lk);
		//return 0;
	}
	
// 좋아요 1인당 1개 감소 
	@CrossOrigin
	@DeleteMapping("/mi/{guest_idx}")
	public int likedown(@PathVariable("guest_idx") int guest_idx,@RequestBody String guest_nick) {
		//System.out.println(guest_nick);
		//System.out.println(guest_idx);
		int a =likedownService.likedown(guest_idx,guest_nick);
		//return 0;
		return a;
	}
	
	
	
	
//	좋아요 숫자증감
	@CrossOrigin
	@PutMapping("/pluscount/{guest_idx}")
	public int likeup(@PathVariable("guest_idx") int guest_idx) {
		return likeupService.likeupcount(guest_idx);
	}
	
	
	
//	좋아요 숫자감소
	@CrossOrigin
	@PutMapping("/micount/{guest_idx}")
	public int likedown(@PathVariable("guest_idx") int guest_idx) {
		int a =likedownService.likedowncount(guest_idx);
		return a;
	}
	
	
// 게시글 삭제
	@CrossOrigin
	@DeleteMapping("/deletec")
	public int deletegb(@RequestBody Map<String, Object> param,
			HttpServletRequest req) {
		int guest_idx= (int)param.get("guest_idx");
		String photo=(String)param.get("guest_photo");
		
	
		return deleteService.deletePost(guest_idx,photo,req);
		//return 0;
	}
	
// 댓글쓰기	
	@CrossOrigin
	@PostMapping("/cmt")
	public int cmtworite(guest_comment cm) {
		return writeCmtService.writeCmt(cm);
	}
	
//댓글 한개 출력	
	@CrossOrigin
	@GetMapping("/cmt/{comment_idx}")
	public guest_comment ViewCmt(@PathVariable("comment_idx") int comment_idx) {
		return cmtViewService.getcmt(comment_idx);
	}
	
	
// 댓글 삭제
	@CrossOrigin
	@DeleteMapping("/delcmt/{comment_idx}")
	public int deletecmt(@PathVariable("comment_idx") int comment_idx) {
		return cmtDeleteServcie.delcmt(comment_idx);
	}
	
	
	
// 댓글 수정
	@CrossOrigin
	@PutMapping("/cmtedit")
	public int editcmttext(@RequestBody Map<String, Object> param) {
		String cmtedittext=(String)param.get("cmtedittext");
		String cmteditidx2=(String)param.get("cmteditidx");
		int cmteditidx =Integer.parseInt(cmteditidx2);
		return cmteditService.editcmt(cmtedittext,cmteditidx);
	}
	
	
// 게시글 전체 카운트	
	@CrossOrigin
	@GetMapping("/test")
	public int test(@RequestParam("x") double x ,@RequestParam("y") double y,@RequestParam("r") int r) {
		return testservice.atest(x,y,r);
	}
	
	
//  수정	
	@CrossOrigin
	@PostMapping("/edi")
	public int edit(HttpServletRequest request , Guest_edit edit) {
		System.out.println(edit.toString());
		if(edit.getOldFile().trim().length()==0) {
			edit.setOldFile(null);
		}
		return editservice.edit(request,edit);
		//return 0;
	}
	
	
	
// 자기가쓴글만 출력
	@CrossOrigin
	@GetMapping("/loginnick")
	public List<Guest_book> bk(@RequestParam("bb") String bb,@RequestParam("limit") int page ) {
		return sessionViewService.getnickListView(bb,page);
	}
	
	
//	자기가 쓴 게시글 댓글 카운트
	@CrossOrigin
	@GetMapping("/mycount")
	public Guest_count count(@Param("bb") String bb ) {
		return countService.Mycount(bb);
	}
	
	
}
