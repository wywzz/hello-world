package com.cy.pj.common;

public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 8857063053462567704L;
	public ServiceException() {
		// TODO Auto-generated constructor stub
	}
	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
	public ServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
