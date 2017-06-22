package com.test.entity;

import java.io.Serializable;

public class Test implements Serializable {
	
	private static final long serialVersionUID = 1448171440623446509L;

	String tn;

	public String getTn() {
		return tn;
	}

	public void setTn(String tn) {
		this.tn = tn;
	}

}
