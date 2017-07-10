package com.test.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.exception.MyException;
import com.test.service.ITestService;

@Controller
@RequestMapping("/tc")
public class TestController {

	@Resource
	ITestService testServiceImpl;


	@ResponseBody
	@RequestMapping(value = "/m", method = RequestMethod.GET)
	public String test(HttpServletRequest req, HttpServletResponse resp) throws MyException{
		String info = null;
		try {
			info = testServiceImpl.test("123");
		} catch (Exception e) {
			throw new MyException(e);
		}
		return info;
	}
}
