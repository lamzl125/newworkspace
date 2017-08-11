package com.shzqoa.util;

public class ResultObject {

	private static ResultObject resultObject;

	private boolean success = true;

	private Object resultData;

	private String resultMessage;

	public static ResultObject getResultObject() {
		if (resultObject == null) {
			resultObject = new ResultObject();
		}
		return resultObject;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getResultData() {
		return resultData;
	}

	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

}
