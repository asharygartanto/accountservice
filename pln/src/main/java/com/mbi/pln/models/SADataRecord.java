package com.mbi.pln.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class SADataRecord {
	private float BeginningBalance;
	private float AvailableBalance;
	private float HoldAmount;
	private float AccruedInterest;
	private float TodayClearing;
	private float YesterdayClearing;
	private float ForexAcumAmt;
	

	public float getBeginningBalance() {
		return BeginningBalance;
	}

	public void setBeginningBalance(float beginningBalance) {
		this.BeginningBalance = beginningBalance;
	}

	public float getAvailableBalance() {
		return AvailableBalance;
	}

	public void setAvailableBalance(float availableBalance) {
		this.AvailableBalance = availableBalance;
	}

	public float getHoldAmount() {
		return HoldAmount;
	}

	public void setHoldAmount(float holdAmount) {
		this.HoldAmount = holdAmount;
	}

	public float getAccruedInterest() {
		return AccruedInterest;
	}

	public void setAccruedInterest(float accruedInterest) {
		AccruedInterest = accruedInterest;
	}

	public float getTodayClearing() {
		return TodayClearing;
	}

	public void setTodayClearing(float todayClearing) {
		TodayClearing = todayClearing;
	}

	public float getYesterdayClearing() {
		return YesterdayClearing;
	}

	public void setYesterdayClearing(float yesterdayClearing) {
		YesterdayClearing = yesterdayClearing;
	}

	public float getForexAcumAmt() {
		return ForexAcumAmt;
	}

	public void setForexAcumAmt(float forexAcumAmt) {
		ForexAcumAmt = forexAcumAmt;
	}
}
