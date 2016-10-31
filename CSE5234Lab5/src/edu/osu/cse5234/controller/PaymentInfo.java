package edu.osu.cse5234.controller;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "PAYMENT_INFO")
public class PaymentInfo implements Serializable {

	private static final long serialVersionUID = 4718393482552017677L;

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "ID")
	private int id;
	
	//@Column(name = "CREDIT_CARD_NUMBER")
	private String creditCardNumber;
	
	//@Column(name = "EXPIRATION_DATE")
	private String expirationDate;
	
	//@Column(name = "CVV_CODE")
	private String cvvCode;
	
	//@Column(name = "CARD_HOLDER_NAME")
	private String cardHolderName;
	
	//@Column(name = "CUSTOMER_ORDER_ID_FK")
	//private int customerOrderId;
	
	/*
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID", insertable=false, updatable=false)
	private Order order;
	*/
	
	public PaymentInfo() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "CREDIT_CARD_NUMBER")
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	@Column(name = "EXPIRATION_DATE")
	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Column(name = "CVV_CODE")
	public String getCvvCode() {
		return cvvCode;
	}

	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}

	@Column(name = "CARD_HOLDER_NAME")
	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	/*
	@Column(name = "CUSTOMER_ORDER_ID_FK")
	public int getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	*/
	
	/*
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	*/
}
