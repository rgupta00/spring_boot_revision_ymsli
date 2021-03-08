package com.empapp.controller.exceptions;

import java.util.Date;

import lombok.Data;
@Data
public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;
	private String email;
	public ErrorDetails(Date timestamp, String message, String details, String email) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.email = email;
	}
	
	
}
