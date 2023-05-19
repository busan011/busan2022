package com.bit.boot04.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.boot04.model.DeptVo;
import com.bit.boot04.service.DeptService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/")
@AllArgsConstructor
@CrossOrigin
public class DeptController {
	private final DeptService deptService;

	@GetMapping
	public List<?> list() {
		return deptService.selectAll();
	}
	@PostMapping
	public ResponseEntity<?> add(@ModelAttribute("bean") DeptVo bean){
		try {
			deptService.insertOne(bean);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{deptno}")
	public ResponseEntity<?> detail(@PathVariable("deptno") int deptno) {
		log.debug("call detail...");
		System.out.println("call detail....");
		DeptVo bean=deptService.selectOne(deptno);
		if(bean!=null)
			return ResponseEntity.ok(bean);
		return ResponseEntity.notFound().build();
	}
	@PutMapping("/{deptno}")
//	public ResponseEntity<?> edit(@ModelAttribute("bean") DeptVo bean){
	public ResponseEntity<?> edit(@RequestBody DeptVo bean){	
		if(deptService.updateOne(bean)>0)
			return ResponseEntity.ok(bean);
		return ResponseEntity.internalServerError().build();
	}
	
	@DeleteMapping("/{deptno}")
	public ResponseEntity<?> delete(@PathVariable("deptno") int deptno){
		if(deptService.deleteOne(deptno)>0)
			return ResponseEntity.ok().build();
		return ResponseEntity.badRequest().build();
	}
	
}







