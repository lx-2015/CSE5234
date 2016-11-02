package com.chase.payment;

import java.io.Serializable;

public class CreditCardPayment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4253579868550245328L;
	private String creditCardNumber;
	private String expirationDate;
	private String cvvCode;
	private String cardHolderName;
	
	public CreditCardPayment() {
		
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