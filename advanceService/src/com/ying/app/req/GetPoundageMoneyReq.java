package com.ying.app.req;

public class GetPoundageMoneyReq extends Req{
	private String proviceCode;		//省的编码
	private String areaCode;		//区的编码
	private String advances; //1物流垫付 0：不垫付

	
	public String getAdvances() {
		return advances;
	}

	public void setAdvances(String advances) {
		this.advances = advances;
	}

	public String getProviceCode() {
		return proviceCode;
	}

	public void setProviceCode(String proviceCode) {
		this.proviceCode = proviceCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	
}
