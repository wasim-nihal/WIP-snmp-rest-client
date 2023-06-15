package com.snmprest.client.errors;

/**
 * 
 * @author snihal
 *
 */
public class RequestProcessingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4187241421492332338L;
	private ErrorMessage error;

	public RequestProcessingException(ErrorMessage error) {
		super();
		this.error = error;
	}

	public ErrorMessage getError() {
		return error;
	}

	public void setError(ErrorMessage error) {
		this.error = error;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
