package com.mbi.pln.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ChannelHeader {
	private String messageID;
	private String branchCode;
	private String channelID;
	private String clientSupervisorID;
	private String clientUserID;
	private String reference;
	private String sequenceno;
	private String transactiondate;
	private String transactiontime;
	

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public String getChannelID() {
		return channelID;
	}

	public void setChannelID(String channelID) {
		this.channelID = channelID;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
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
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getSequenceno() {
		return sequenceno;
	}

	public void setSequenceno(String sequenceno) {
		this.sequenceno = sequenceno;
	}

	public String getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}

	public String getTransactiontime() {
		return transactiontime;
	}

	public void setTransactiontime(String transactiontime) {
		this.transactiontime = transactiontime;
	}

}
