package com.bitacademy.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.vo.BlogVo;

@Repository("BlogDao")
public class BlogDaoImpl implements BlogDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(BlogVo vo) {

		int insertedCount =0;
		try {
			insertedCount=sqlSession.insert("blog.insert",vo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return insertedCount;
	}

}
