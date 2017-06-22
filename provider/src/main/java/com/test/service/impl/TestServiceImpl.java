package com.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.TestDao;
import com.test.entity.Test;
import com.test.redis.RedisClientTemplate;
import com.test.service.ITestService;

@Resource
@Service("testServiceImpl")
public class TestServiceImpl implements ITestService {
	
	@Autowired
	TestDao testDao;
	
	@Autowired
	RedisClientTemplate redisClientTemplate;
	
	@Override
	public String test(String key) {
		return retStr(key);
	}
	
	private String retStr(String key){
		StringBuffer sb = new StringBuffer();
		sb.append("provider = " + this.getClass().getName() + "</p>");
		boolean isExists = redisClientTemplate.exists(key);
		try {
			List<Test> list = null;
			String redisStr = null;
			if(isExists){
				redisStr = redisClientTemplate.get(key);
				sb.append("data from redis = " + redisStr);
				sb.append("</p>");
			}else{
				redisClientTemplate.set(key, "yes it's my key");
			}
			
			list = testDao.selectRecord(null);
			for(Test test : list){
				sb.append(test.getTn());
				sb.append("</p>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
