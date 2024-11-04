package com.student.tech.dto;

public class ResponseStructure <T>{
	String message;
	int status;
	
	
	public ResponseStructure(String message, int status) {
		this.message = message;
		this.status = status;
	}
	public ResponseStructure() {
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int i) {
		this.status = i;
	}
	@Override
	public String toString() {
		return "ResponseStructure [message=" + message + ", status=" + status + "]";
	}

	
	

}
