package com.pjb.springbootjjwt.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pjb.springbootjjwt.annotation.PassToken;
import com.pjb.springbootjjwt.annotation.UserLoginToken;
import com.pjb.springbootjjwt.entity.User;
import com.pjb.springbootjjwt.service.TokenService;
import com.pjb.springbootjjwt.service.UserService;

/**
 * @author jinbin
 * @date 2018-07-08 20:45
 */
@RestController
@RequestMapping("api")
public class UserApi {
	@Autowired
	UserService userService;
	@Autowired
	TokenService tokenService;

	// 登录
	@PostMapping("/login")
	public Object login(@RequestBody User user) {
		JSONObject jsonObject = new JSONObject();
		User userForBase = userService.findByUsername(user);
		if (userForBase == null) {
			jsonObject.put("message", "登录失败,用户不存在");
			return jsonObject;
		} else {
			if (!userForBase.getPassword().equals(user.getPassword())) {
				jsonObject.put("message", "登录失败,密码错误");
				return jsonObject;
			} else {
				String token = tokenService.getToken(userForBase);
				jsonObject.put("token", token);
				jsonObject.put("user", userForBase);
				return jsonObject;
			}
		}
	}

	@UserLoginToken
	@GetMapping("/getMessage")
	public String getMessage() {
		return "你已通过验证";
	}

	@PassToken
	@GetMapping("/test")
	public String test() {
		return "不需要 验证...";
	}
}
