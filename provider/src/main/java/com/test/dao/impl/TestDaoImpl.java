package com.test.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.dao.TestDao;
import com.test.entity.Test;
import com.test.mybatis.MyBatisDao;


@Repository("testDao")
public class TestDaoImpl extends MyBatisDao implements TestDao{
	
	private static final String namespace = "com.test.dao.TestDao.";

	@Override
	public List<Test> selectRecord(String arg) throws Exception{
		return (List<Test>)super.queryForList(namespace + "selectRecord", arg);
	}

	@Override
	public int deleteRecord(String arg) throws Exception{
		return (Integer)super.delete(namespace + "deleteRecord", arg);
	}
	
}
