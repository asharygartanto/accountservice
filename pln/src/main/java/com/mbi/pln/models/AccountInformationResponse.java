package com.mbi.pln.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="AccountInformationResponse", namespace = "http://www.bankbii.com/AccountServices/")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountInformationResponse {
	
	private String responseCode;
	//private responseDetail responseDetail;
	private AccountInformationResponseData AccountInformationResponseData;
	

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
/*
	public responseDetail getResponseDetail() {
		return responseDetail;
	}

	public void setResponseDetail(responseDetail responseDetail) {
		this.responseDetail = responseDetail;
	}*/

	public AccountInformationResponseData getAccountInformationResponseData() {
		return AccountInformationResponseData;
	}

	public void setAccountInformationResponseData(AccountInformationResponseData accountInformationResponseData) {
		AccountInformationResponseData = accountInformationResponseData;
	}

}
