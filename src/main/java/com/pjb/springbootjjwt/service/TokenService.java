package com.pjb.springbootjjwt.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.pjb.springbootjjwt.entity.User;

/**
 * @author jinbin
 * @date 2018-07-08 21:04
 */
@Service("TokenService")
public class TokenService {
	public String getToken(User user) {
		String token = "";
		// 将 user id 保存到 token 里面
		// 以 password 作为 token 的密钥
		token = JWT.create().withAudience(user.getId()).withExpiresAt(date).sign(Algorithm.HMAC256(user.getPassword()));
		return token;
	}

	// 过期时间，单位毫秒
	// private static final long EXPIRE_TIME = 7 * 24 * 3600 * 1000;
	private static final long EXPIRE_TIME = 5 * 60 * 1000;
	// 生成过期时间
	private static final Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
}
