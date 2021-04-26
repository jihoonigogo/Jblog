package com.bitacademy.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.BlogDao;
import com.bitacademy.jblog.vo.BlogVo;

@Service("BlogService")
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao BlogDao;
	
	@Override
	public boolean join(BlogVo vo) {
		int insertedCount = BlogDao.insert(vo);
		return 1 ==insertedCount;
	}

	
}
