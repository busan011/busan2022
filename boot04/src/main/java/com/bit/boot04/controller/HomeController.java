package com.bit.boot04.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.bit.boot04.model.DeptVo;
import com.bit.boot04.service.DeptService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
public class HomeController {
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
		DeptVo bean=deptService.selectOne(deptno);
		if(bean!=null)
			return ResponseEntity.ok(bean);
		return ResponseEntity.notFound().build();
	}
	@PutMapping("/{deptno}")
//	public ResponseEntity<?> edit(@ModelAttribute("bean") DeptVo bean){
	public ResponseEntity<?> edit(@RequestBody DeptVo bean,HttpServletRequest req) throws URISyntaxException{	
		
		if(deptService.updateOne(bean)>0) {
			RestTemplate template=new RestTemplate();
			log.debug(req.getRequestURL().toString());
			URI url=new URI(req.getRequestURL().toString());
//			URI url=new URI("http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=159");

			//@Nullable T body, HttpMethod method, URI url
			RequestEntity param=new RequestEntity(HttpMethod.GET, url);
			
			return template.exchange(url, HttpMethod.GET, param, DeptVo.class);
		}
		return ResponseEntity.internalServerError().build();
	}
	
	@DeleteMapping("/{deptno}")
	public ResponseEntity<?> delete(@PathVariable("deptno") int deptno){
		if(deptService.deleteOne(deptno)>0)
			return ResponseEntity.ok().build();
		return ResponseEntity.badRequest().build();
	}
}
