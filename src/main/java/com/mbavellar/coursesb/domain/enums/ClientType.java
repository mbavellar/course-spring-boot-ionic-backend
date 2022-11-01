package com.mbavellar.coursesb.domain.enums;

import java.util.stream.Stream;

public enum ClientType {

	NATURAL_PERSON(1, "Natural Person"),
	LEGAL_PERSON(2, "Legal Person");
	
	private int code;
	private String description;
	
	private ClientType(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static ClientType toEnum(int code) {
		return (Stream.of(ClientType.values()).filter(k -> k.getCode() == code)).findAny().orElseThrow();
	}
}
