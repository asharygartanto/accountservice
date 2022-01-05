package com.mbi.pln.controller;

import java.util.List;
//import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableConfigurationProperties
@Component
@ConfigurationProperties(prefix = "application")
public class ApplicationProps {
	private List<String> accountno;
    private String messageID;
    private String branchcode;
    private String channelID;
    private String clientSupervisorID;
    private String clientUserID;
    private String references;
    private String sequencenos;
    private String currencyCode;

	

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public String getBranchCode() {
		return branchcode;
	}

	public void setBranchCode(String branchCode) {
		this.branchcode = branchCode;
	}

	public String getChannelID() {
		return channelID;
	}

	public void setChannelID(String channelID) {
		this.channelID = channelID;
	}

	public String getClientSupervisorID() {
		return clientSupervisorID;
	}

	public void setClientSupervisorID(String clientSupervisorID) {
		this.clientSupervisorID = clientSupervisorID;
	}

	public String getClientUserID() {
		return clientUserID;
	}

	public void setClientUserID(String clientUserID) {
		this.clientUserID = clientUserID;
	}

	public String getReference() {
		return references;
	}

	public void setReference(String reference) {
		this.references = reference;
	}

	public String getSequenceno() {
		return sequencenos;
	}

	public void setSequenceno(String sequenceno) {
		this.sequencenos = sequenceno;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public List<String> getAccountno() {
		return accountno;
	}

	public void setAccountno(List<String> accountno) {
		this.accountno = accountno;
	}
    
    // getter and setter
 
}