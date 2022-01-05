package com.mbi.pln.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class accountStatementResponseData {

	private String accountNo;
	private float openingBalance;
	private float closingBalance;
	private AccountTrxHistoryData AccountTrxHistoryData;
	private String dbkey1;
	private String dbkey2;
	private String dbkey3;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public float getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(float openingBalance) {
		this.openingBalance = openingBalance;
	}

	public float getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(float closingBalance) {
		this.closingBalance = closingBalance;
	}

	public AccountTrxHistoryData getAccountTrxHistoryData() {
		return AccountTrxHistoryData;
	}

	public void setAccountTrxHistoryData(AccountTrxHistoryData accountTrxHistoryData) {
		AccountTrxHistoryData = accountTrxHistoryData;
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
