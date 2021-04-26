package com.bitacademy.jblog.service;

import com.bitacademy.jblog.vo.UserVo;

public interface UserService {
	public boolean join(UserVo vo); // 가입 
	public UserVo getUser(String id,String password) ;// 로그인
	public UserVo getUser(String id);// 이메일 중복체크
}
