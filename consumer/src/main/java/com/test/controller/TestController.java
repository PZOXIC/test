package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.exception.MyException;
import com.test.service.TestServcie;

@Controller
@RequestMapping("/tc")
public class TestController {


	@Autowired
	TestServcie testService;

	@ResponseBody
	@RequestMapping(value = "/m", method = RequestMethod.GET)
	public String select(HttpServletRequest req, HttpServletResponse resp) throws MyException{
		String info = null;
		try {
			info = testService.selectByKey("123");
		} catch (Exception e) {
			throw new MyException(e);
		}
		return info;
	}
	
	@ResponseBody
	@RequestMapping(value = "i", method = RequestMethod.GET)
	public String insert(HttpServletRequest req, HttpServletResponse resp, String value) throws MyException{
		try {
			testService.insert(value);
		} catch (Exception e) {
			throw new MyException(e);
		}
		return "OK";
	}
}
