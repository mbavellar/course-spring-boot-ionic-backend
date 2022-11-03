package com.mbavellar.coursesb.domain.enums;

public enum PaymentState {

	PENDING(1, "Pending"),
	SETTLED(2, "Settled"),
	CANCELED(2, "Canceled");
	
	private int code;
	private String description;
	
	private PaymentState(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	public static PaymentState toEnum(int code) {
		for (var e : PaymentState.values()) {
			if (e.getCode() == code) return e;
		}
		throw new IllegalArgumentException("Invalid ID: " + code);
	}
}
