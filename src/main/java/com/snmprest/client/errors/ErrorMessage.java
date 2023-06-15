package com.snmprest.client.errors;

/**
 * 
 * @author snihal
 *
 */
public class ErrorMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 526564136487334734L;
	private String Error;
	private int ErrorIndex;
	private int ErrorStatus;
	private String ErrorMessage;

	public ErrorMessage(String error, int errorIndex, int errorStatus, String errorMessage) {
		super();
		Error = error;
		ErrorIndex = errorIndex;
		ErrorStatus = errorStatus;
		ErrorMessage = errorMessage;
	}

	public String getError() {
		return Error;
	}

	public void setError(String error) {
		Error = error;
	}

	public int getErrorIndex() {
		return ErrorIndex;
	}

	public void setErrorIndex(int errorIndex) {
		ErrorIndex = errorIndex;
	}

	public int getErrorStatus() {
		return ErrorStatus;
	}

	public void setErrorStatus(int errorStatus) {
		ErrorStatus = errorStatus;
	}

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ErrorVarBinding [Error=" + Error + ", ErrorIndex=" + ErrorIndex + ", ErrorStatus=" + ErrorStatus
				+ ", ErrorMessage=" + ErrorMessage + "]";
	}

}
