package com.mbi.pln.models;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class AccountData {
	private List<SADataRecord> SADataRecord;

	public List<SADataRecord> getSADataRecord() {
		return SADataRecord;
	}

	public void setSADataRecord(List<SADataRecord> sADataRecord) {
		SADataRecord = sADataRecord;
	} 

}
