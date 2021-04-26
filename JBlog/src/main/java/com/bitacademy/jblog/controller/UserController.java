package com.bitacademy.jblog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.jblog.service.UserService;
import com.bitacademy.jblog.vo.UserVo;


@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	//1. 회원가입 화면
	@RequestMapping(value = {"","/","/join"}, method=RequestMethod.GET)
	public String join (@ModelAttribute UserVo UserVo) {
		return "users/joinform";
	}
	
	//2.회원가입 처리
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinAction(@ModelAttribute @Valid UserVo userVo) {
		System.out.println("form으로 전송될 데이터 : " + userVo);
		
		boolean success = userService.join(userVo);
		if(success) { // 성공시
			System.out.println("가입 성공");
			return "redirect:/users/joinsuccess";			
		}else {
			System.err.println("가입 실패");
			return "redirect:/users/"; 
		}
		
	}
	
	//3.회원가입 성공화면 
	@RequestMapping("/joinsuccess")
	public String joinsuccess() {
		return "users/joinsuccess";
	}
	
	//4.아이디 중복체크 ★★★★★★★★★★★★★★★★★★★★★★이해해봐야함..
	@RequestMapping("/idcheck")
	@ResponseBody
	public Object existId(@RequestParam(value="id",required=false,defaultValue="")
			String id) {
		UserVo vo = userService.getUser(id);
		boolean exists = vo != null? true : false;// vo 객체가 null -> 이미 존재하는 사용자

		// 결과 MAP -> 컨버터 -> JSON 변환
		
		Map<String,Object> map = new HashMap<>();
		map.put("result","success");
		map.put("data", exists);
		return map;
		
	}
	
	//JSON매핑 확인(?)
			@RequestMapping("/show")
			@ResponseBody// Message Converter
			public Object showUserById(@RequestParam String id){
				UserVo vo = userService.getUser(id);
				return vo;
			}
	
	//5.로그인 화면 
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginForm() {
		return "users/loginform";
		
	}
	
	
	//6.로그인 처리
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginAction(@RequestParam String id,
			@RequestParam String password, HttpSession session) {
		UserVo authUser = userService.getUser(id, password);
		
		if(authUser != null) {
			session.setAttribute("authUser", authUser);
			return "redirect:/"; 
		}else {
			return "redirect:/users/login";
		}
	}


	//7. 로그아웃 처리
	@RequestMapping("/logout")
	public String logoutAction(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}
}
