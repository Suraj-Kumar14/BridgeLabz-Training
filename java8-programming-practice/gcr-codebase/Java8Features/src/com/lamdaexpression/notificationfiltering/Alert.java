package com.lamdaexpression.notificationfiltering;

public class Alert {
	private String type;
	private String message;
	
	public Alert(String type, String message) {
		super();
		this.type = type;
		this.message = message;
	}
	
	public String getType() {
		return type;
	}
	
	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return "Alert [type=" + type + ", message=" + message + "]";
	}
	
	
}
