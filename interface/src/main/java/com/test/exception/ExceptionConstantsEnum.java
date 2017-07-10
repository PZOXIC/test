package com.test.exception;

/**
 * 错误码格式：字母+数字，字母长度为2-10，数字为2-5位长度
 * 从aa00 到ZZZZZZZZZZ99999
 * @author lenovo
 *
 */
public enum ExceptionConstantsEnum {
	// TODO 新增异常按顺序往下写
	CARD_001("卡号错误"),
	
	COUNT_001("帐号错误"),
	
	IDCARD_001("身份证号错误"),
	
	ZZZZZ_99999("测试异常");
	
	private String message;
	
	private ExceptionConstantsEnum(String message) {
		this.message = message;
	}
	
	
	public String getMessage(){
		return message;
	}
	
	public static String getMessageByCode(String code){
		String message = null;
		try {
			message = ExceptionConstantsEnum.valueOf(code).getMessage();
		} catch (Exception e) {
			// no message
		}
		return message;
	}
}
