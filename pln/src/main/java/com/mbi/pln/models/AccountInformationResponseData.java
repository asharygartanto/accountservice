package com.mbi.pln.models;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class AccountInformationResponseData {
	
	private String AccountName;
	private String CIF_No;
	private String AccountStatus;
	
	private String Address1;
	private String Address2;
	private String Address3;
	private String Address4;
	private List<AccountData> AccountData;


	private String ApplCode;
	private String ProductCode;
	private String SubBranch;
	private String xSeller;
	private String CardNumber;
	

	private float TransactionInAmount;
	private float TransactionOutAmount;
	private String TransactionInFrequency;
	private String TransactionOutFrequency;
	private String SourceOfFund;
	private String PurposeOfFund;
	
	public String getAccountName() {
		return AccountName;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public String getCIF_No() {
		return CIF_No;
	}

	public void setCIF_No(String cIF_No) {
		CIF_No = cIF_No;
	}

	public String getAccountStatus() {
		return AccountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		AccountStatus = accountStatus;
	}

	public String getAddress1() {
		return Address1;
	}

	public void setAddress1(String address1) {
		Address1 = address1;
	}

	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String address2) {
		Address2 = address2;
	}

	public String getAddress3() {
		return Address3;
	}

	public void setAddress3(String address3) {
		Address3 = address3;
	}

	public String getAddress4() {
		return Address4;
	}

	public void setAddress4(String address4) {
		Address4 = address4;
	}

	public List<AccountData> getAccountData() {
		return AccountData;
	}

	public void setAccountData(List<AccountData> accountData) {
		AccountData =  accountData;
	}

	public String getApplCode() {
		return ApplCode;
	}

	public void setApplCode(String applCode) {
		ApplCode = applCode;
	}

	public String getProductCode() {
		return ProductCode;
	}

	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}

	public String getxSeller() {
		return xSeller;
	}

	public void setxSeller(String xSeller) {
		this.xSeller = xSeller;
	}

	public String getSubBranch() {
		return SubBranch;
	}

	public void setSubBranch(String subBranch) {
		SubBranch = subBranch;
	}

	public String getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}

	public float getTransactionInAmount() {
		return TransactionInAmount;
	}

	public void setTransactionInAmount(float transactionInAmount) {
		TransactionInAmount = transactionInAmount;
	}

	public float getTransactionOutAmount() {
		return TransactionOutAmount;
	}

	public void setTransactionOutAmount(float transactionOutAmount) {
		TransactionOutAmount = transactionOutAmount;
	}

	public String getTransactionInFrequency() {
		return TransactionInFrequency;
	}

	public void setTransactionInFrequency(String transactionInFrequency) {
		TransactionInFrequency = transactionInFrequency;
	}

	public String getTransactionOutFrequency() {
		return TransactionOutFrequency;
	}

	public void setTransactionOutFrequency(String transactionOutFrequency) {
		TransactionOutFrequency = transactionOutFrequency;
	}

	public String getSourceOfFund() {
		return SourceOfFund;
	}

	public void setSourceOfFund(String sourceOfFund) {
		SourceOfFund = sourceOfFund;
	}

	public String getPurposeOfFund() {
		return PurposeOfFund;
	}

	public void setPurposeOfFund(String purposeOfFund) {
		PurposeOfFund = purposeOfFund;
	}


}
