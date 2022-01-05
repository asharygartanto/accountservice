package com.mbi.pln.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name  ="AccountInformation", namespace = "http://www.bankbii.com/AccountServices/")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountInformation {
	private ChannelHeader ChannelHeader;
	private AccountInformationRequest AccountInformationRequest; 

	public ChannelHeader getChannelHeader() {
		return ChannelHeader;
	}

	public void setChannelHeader(ChannelHeader channelHeader) {
		ChannelHeader = channelHeader;
	}

	public AccountInformationRequest getAccountInformationRequest() {
		return AccountInformationRequest;
	}

	public void setAccountInformationRequest(AccountInformationRequest accountInformationRequest) {
		AccountInformationRequest = accountInformationRequest;
	}

}
