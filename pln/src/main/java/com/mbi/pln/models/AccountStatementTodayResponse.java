package com.mbi.pln.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="AccountStatementTodayResponse", namespace = "http://www.bankbii.com/AccountServices/")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountStatementTodayResponse {
	
	private String responseCode;
	//private responseDetail responseDetail;
	private accountStatementResponseData accountStatementResponseData;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	/*public responseDetail getResponseDetail() {
		return responseDetail;
	}
	public void setResponseDetail(responseDetail responseDetail) {
		this.responseDetail = responseDetail;
	}*/
	public accountStatementResponseData getAccountStatementResponseData() {
		return accountStatementResponseData;
	}
	public void setAccountStatementResponseData(accountStatementResponseData accountStatementResponseData) {
		this.accountStatementResponseData = accountStatementResponseData;
	}
	

}
