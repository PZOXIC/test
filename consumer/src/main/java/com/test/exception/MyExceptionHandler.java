package com.test.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler implements HandlerExceptionResolver {

	Pattern pattern = Pattern.compile("[a-zA-Z]{2,5}[_]\\d{2,5}");

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		// TODO Logger记录日志

		Map<String, Object> model = new HashMap<String, Object>();
		// model.put("ex", ex);
		String code = ex.getMessage();

		// TODO 页面需要把ex的值取出来
		if (ex instanceof MyException) {
			Matcher m = pattern.matcher(code);
			if(m.find()){
				m.reset();
				String message = ExceptionConstantsEnum.getMessageByCode(code);
				String retMsg = code + ":" + message;
				model.put("ex", retMsg);
			}else{
				model.put("ex", ex);
			}
			return new ModelAndView("/error.jsp", model);
		}
		return null;
	}

}
