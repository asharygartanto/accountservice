package com.mbi.pln.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class AccountInformationRequest {
	private String accountNo;
	private String accountBranchCode;
	private String accountCurrency;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountBranchCode() {
		return accountBranchCode;
	}

	public void setAccountBranchCode(String accountBranchCode) {
		this.accountBranchCode = accountBranchCode;
	}

	public String getAccountCurrency() {
		return accountCurrency;
	}

	public void setAccountCurrency(String accountCurrency) {
		this.accountCurrency = accountCurrency;
	}

}
