package com.test.service;


import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

@Service
public class TestServcie {
	@Reference
	ITestService testService;
	
	public String selectByKey(String key) throws Exception{
		return testService.selectByKey(key);
	}
	
	public int insert(String value) throws Exception{
		return testService.insert(value);
	}
}
