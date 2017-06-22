package com.test.dao;

import java.util.List;

import com.test.entity.Test;

public interface TestDao {
	public List<Test> selectRecord(String arg) throws Exception;
	
	public int deleteRecord(String arg) throws Exception;

}
