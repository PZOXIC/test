package com.test.dubbo;

public interface DubboService {
	String selectByKey(String key) throws Exception;

	int insert(String value) throws Exception;
}
