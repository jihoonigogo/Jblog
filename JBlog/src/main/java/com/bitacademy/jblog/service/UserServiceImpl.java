package com.bitacademy.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.UserDao;
import com.bitacademy.jblog.vo.UserVo;

@Service("userservice")
public class UserServiceImpl implements UserService {

		@Autowired
		private UserDao userDao;
	
	
	//회원가입
	@Override
	public boolean join(UserVo vo) {
		int insertedCount =userDao.insert(vo);
		
		return 1 == insertedCount;
	}

	//로그인 처리
	@Override
	public UserVo getUser(String id, String password) {
		UserVo vo = userDao.selectUser(id, password);
		return vo;
	}

	// 아이디 중복체크
	@Override
	public UserVo getUser(String id) {
		UserVo vo = userDao.selectUser(id);
		return vo;
	}

}
