package com.bit.boot04.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bit.boot04.model.DeptMapper;
import com.bit.boot04.model.DeptVo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class DeptService {

	private final SqlSession sqlSession;
	
	public List<DeptVo> selectAll(){
		return sqlSession.getMapper(DeptMapper.class).findAll();
	}
	
	public DeptVo selectOne(int deptno) {
		return sqlSession.getMapper(DeptMapper.class).findOne(deptno);
	}
	
	@Transactional
	public void insertOne(DeptVo bean) {
		sqlSession.getMapper(DeptMapper.class).insertOne(bean);
	}
	
	@Transactional
	public int updateOne(DeptVo bean) {
		return sqlSession.getMapper(DeptMapper.class).updateOne(bean);
	}
	
	@Transactional
	public int deleteOne(int deptno) {
		return sqlSession.getMapper(DeptMapper.class).deleteOne(deptno);
	}
}








