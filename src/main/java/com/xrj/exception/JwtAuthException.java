package com.xrj.exception;

/**
 * jwt认证失败
 * @author crixus
 *
 */
public class JwtAuthException extends RuntimeException {

	private static final long serialVersionUID = -7097941781283911432L;

	public JwtAuthException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JwtAuthException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public JwtAuthException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public JwtAuthException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


}
