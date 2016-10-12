package edu.osu.cse5234.controller;

import java.io.Serializable;

public class PaymentInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4718393482552017677L;
	private String creditCardNumber;
	private String expirationDate;
	private String cvvCode;
	private String cardHolderName;
	
	public PaymentInfo() {
		creditCardNumber = null;
		expirationDate = null;
		cvvCode = null;
		cardHolderName = null;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCvvCode() {
		return cvvCode;
	}

	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	
}
