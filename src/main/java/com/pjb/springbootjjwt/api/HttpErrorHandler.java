package com.pjb.springbootjjwt.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pjb.springbootjjwt.common.result.JsonResult;

@Controller
public class HttpErrorHandler implements ErrorController {

	private final static String ERROR_PATH = "/error";

	@RequestMapping(value = ERROR_PATH, produces = "text/html")
	public String errorHtml(HttpServletRequest request) {
		System.out.println("html");
		return "404";
	}

	@RequestMapping(value = ERROR_PATH)
	@ResponseBody
	public JsonResult<String> error(HttpServletRequest request) {
		return JsonResult.error(404, "接口没有找到");
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return ERROR_PATH;
	}

}
