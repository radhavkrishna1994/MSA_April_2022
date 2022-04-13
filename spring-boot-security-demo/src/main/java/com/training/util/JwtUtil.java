package com.training.util;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
// generate a token based on the username
public class JwtUtil {
	
	public String generateToken(String username)
	{
		Map<String,Object> claims = new HashMap<>();
		claims.put("project","abc");
		return createToken(claims,username);
	}

	private String secretKey = "jwttest";
	
	private String createToken(Map<String, Object> claims, String username) {
		
		String token = Jwts.builder()
		.setClaims(claims)
		.setSubject(username)
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 1))
		.signWith(SignatureAlgorithm.HS256, secretKey).compact();
		
		return token;
	}
	
	

}
