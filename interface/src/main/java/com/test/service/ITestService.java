package com.test.service;



public interface ITestService {
	String selectByKey(String key) throws Exception;
	
	int insert(String value) throws Exception;
}
