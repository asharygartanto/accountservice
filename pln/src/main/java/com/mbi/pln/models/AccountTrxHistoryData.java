package com.mbi.pln.models;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class AccountTrxHistoryData {

	private List<TrxElement> TrxElement;

	public List<TrxElement> getTrxElement() {
		return TrxElement;
	}

	public void setTrxElement(List<TrxElement> trxElement) {
		TrxElement = trxElement;
	}
}
