package com.mbavellar.coursesb.enums;

public enum OrderBy {
	
	NAME("name");
	
	private String value;
	
	OrderBy(String value) { this.value = value; }
	
	public String getValue() {
		return value;
	}
}
