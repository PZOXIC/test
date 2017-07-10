package com.test.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import com.test.service.ITestService;

public class SysLogAspect {

	private static final Logger logger = Logger.getLogger(SysLogAspect.class);

	public SysLogAspect() {
		System.out.println("==============SysLogAspect===============");
	}

	public void doBefore(JoinPoint point) {
		logger.info("doBefore");
	}

	/**
	 * 可以修改原service的参数之类的东西，原方法不再执行。
	 * 注意，没返回值
	 * @param pjp
	 */
	public String doAround(ProceedingJoinPoint pjp) throws Exception{
		logger.info("doAround");
		Object[] args = pjp.getArgs();
		for(int i=0;i<args.length;i++){
			Object arg = args[i];
			// 改变某种类型的参数值，比如加前缀什么的
			if(arg instanceof String){
				args[i] = "ZAQWSX1234";
			}
		}
		try {
			return (String)pjp.proceed(args);
		} catch (Throwable e) {
			e.printStackTrace();
			logger.error(e);
		}
		return null;
	}
	
	public void doReturn(){
		
	}

	public void doAfter(JoinPoint point) {
		logger.info("doAfter");
	}

	public void doThrowing(JoinPoint point, Throwable e) {
		logger.info("doThrowing");
	}
}
