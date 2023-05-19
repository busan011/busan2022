package com.bit.boot05.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bit.boot05.domain.DeptRepo;
import com.bit.boot05.domain.entity.Dept2;
import com.bit.boot05.domain.entity.DeptVo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class DeptService {
	
	private final DeptRepo deptRepo;

	public List<?> selectAll(){
		List<DeptVo> list=new java.util.ArrayList<>();
		deptRepo.findAll().forEach((ele)->{
			list.add(DeptVo.builder()
			.deptno(ele.getDeptno())
			.dname(ele.getDname())
			.loc(ele.getLoc())
			.build());
		});
		return list;
	}
	
}








