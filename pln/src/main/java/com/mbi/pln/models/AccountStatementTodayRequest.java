package com.mbi.pln.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class AccountStatementTodayRequest {

	private String accountNo;
	private String accountBranchCode;
	private String accountCurrency;
	private String recordNum;
	private String dbkey1;
	private String dbkey2;
	private String dbkey3;

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

	public String getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
	}

	public String getDbkey1() {
		return dbkey1;
	}

	public void setDbkey1(String dbkey1) {
		this.dbkey1 = dbkey1;
	}

	public String getDbkey2() {
		return dbkey2;
	}

	public void setDbkey2(String dbkey2) {
		this.dbkey2 = dbkey2;
	}

	public String getDbkey3() {
		return dbkey3;
	}

	public void setDbkey3(String dbkey3) {
		this.dbkey3 = dbkey3;
	}


}
