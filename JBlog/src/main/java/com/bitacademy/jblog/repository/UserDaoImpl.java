package com.bitacademy.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.vo.UserVo;

@Repository("userdao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//회원가입용
	@Override
	public int insert(UserVo vo) { 
		// TODO Auto-generated method stub
		int insertedCount =0;
		try {
			insertedCount=sqlSession.insert("users.insert",vo);
		}catch(Exception e) {
			System.err.println("회원가입 에러 발생 :" + e.getMessage());
			
		}
		return insertedCount;
	}

	@Override
	public UserVo selectUser(String id, String password) { //로그인용
		Map<String,String> userMap = new HashMap<>();
		userMap.put("id", id);
		userMap.put("password", password);
		UserVo vo = sqlSession.selectOne("users.selectUserByIdAndPassword", userMap);
		return vo;
	}

	@Override
	public UserVo selectUser(String id) { //아이디 중복체크용
		UserVo vo = sqlSession.selectOne("users.selectUserById",id);
		return vo;
	}

}
