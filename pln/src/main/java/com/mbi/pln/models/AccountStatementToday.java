package com.mbi.pln.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name  ="AccountStatementToday", namespace = "http://www.bankbii.com/AccountServices/")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountStatementToday {
	
	private ChannelHeader ChannelHeader;
	private AccountStatementTodayRequest AccountStatementTodayRequest; 

	public ChannelHeader getChannelHeader() {
		return ChannelHeader;
	}

	public void setChannelHeader(ChannelHeader channelHeader) {
		ChannelHeader = channelHeader;
	}

	public AccountStatementTodayRequest getAccountInformationRequest() {
		return AccountStatementTodayRequest;
	}

	public void setAccountStatementTodayRequest(AccountStatementTodayRequest accountStatementTodayRequest) {
		AccountStatementTodayRequest = accountStatementTodayRequest;
	}
}
