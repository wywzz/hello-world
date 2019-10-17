package com.cy.pj.common.exception;
//RuntimeException非检查异常
//如果用Exception每个用到这个自己写的异常都要抛出异常
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 5843835376260549700L;
	public ServiceException() {
		super();
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
