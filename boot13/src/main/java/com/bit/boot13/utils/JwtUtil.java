package com.bit.boot13.utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
	@Value("${sec.key}")
	String key="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	
	public Jws<Claims> getJwt(String compactJws) {
		SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes());
		try {
		    return Jwts.parserBuilder().setSigningKey(secretKey)
		    	.build().parseClaimsJws(compactJws);
		} catch (JwtException e) {
		}
		return null;
	}
	
	public String getJwtName(String compactJws) {
		return getJwt(compactJws)==null?
				null:(String) getJwt(compactJws).getBody().get("ename");
	}
	

	public String createJwt(String name,long limit) {
		SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes());
		return Jwts.builder()
			    .setSubject("Bob")
			    .claim("ename", name)
			    .setExpiration(new Date(System.currentTimeMillis()+limit))
			    .signWith(secretKey,SignatureAlgorithm.HS256)
			    .compact(); 
	}
	public String createJwt(String name) {
		return createJwt(name, 1000*60);
	}
	public String createJwt() {
		return createJwt("tester", 1000*60);
	}
}
