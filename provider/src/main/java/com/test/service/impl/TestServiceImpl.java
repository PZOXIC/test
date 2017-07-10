package com.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.test.dao.TestDao;
import com.test.entity.Test;
import com.test.redis.RedisClientTemplate;
import com.test.service.ITestService;

@Resource
@Service("testServiceImpl")
public class TestServiceImpl implements ITestService {
	private static Logger log = Logger.getLogger(TestServiceImpl.class);

	@Resource
	TestDao testDao;

	@Resource
	RedisClientTemplate redisClientTemplate;

	@Override
	public String test(String key) throws Exception {
//		if (1 != 1) {
//			throw new Exception(ExceptionConstantsEnum.CARD_001.toString());
//		}
		StringBuffer sb = new StringBuffer();
		sb.append("provider = " + this.getClass().getName() + "</p>");
		boolean isExists = redisClientTemplate.exists(key);
		try {
			List<Test> list = null;
			String redisStr = null;
			if (isExists) {
				redisStr = redisClientTemplate.get(key);
				sb.append("data from redis = " + redisStr);
				sb.append("</p>");
			} else {
				redisClientTemplate.set(key, "yes it's my key");
			}

			list = testDao.selectRecord(null);
			for (Test test : list) {
				sb.append(test.getTn());
				sb.append("</p>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return sb.toString();
	}

}
