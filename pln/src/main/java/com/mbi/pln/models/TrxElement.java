package com.mbi.pln.models;

//import java.sql.Date;
//import java.sql.Time;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class TrxElement {

	private String Date;
	private String Time;
	private String Description;
	private float Amount;
	private String DBCR;
	private String TranCode;

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public float getAmount() {
		return Amount;
	}

	public void setAmount(float amount) {
		Amount = amount;
	}

	public String getDBCR() {
		return DBCR;
	}

	public void setDBCR(String dBCR) {
		DBCR = dBCR;
	}

	public String getTranCode() {
		return TranCode;
	}

	public void setTranCode(String tranCode) {
		TranCode = tranCode;
	} 
}
