package com.bitacademy.jblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.jblog.service.BlogService;
import com.bitacademy.jblog.service.UserService;
import com.bitacademy.jblog.vo.BlogVo;

@Controller
@RequestMapping({"/{id}"})
public class BlogController {
	
	@Autowired
	private BlogService BlogService;
	
	@Autowired
	private UserService UserService;

	@RequestMapping(value="/")
	public String joinAction(@ModelAttribute @Valid BlogVo vo) {
//		System.out.println("블로그 관리자 : " + UserService.getUser(String id));
//		
		boolean success = BlogService.join(BlogVo vo);
		if(success) { // 성공시
			System.out.println("가입 성공");
			return "redirect:/users/joinsuccess";			
		}else {
			System.err.println("가입 실패");
			return "redirect:/users/"; 
		}		
	}
	
	@RequestMapping("/{id}")
	public String view(@PathVariable BlogVo UserVo){
		
		return "blog/main";
	}
	
}
