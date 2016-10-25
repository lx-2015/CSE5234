package edu.osu.cse5234.business.view;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "PAYMENT_INFO")
public class PaymentInfo implements Serializable {

	private static final long serialVersionUID = 4718393482552017677L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "CREDIT_CARD_NUMBER")
	private String creditCardNumber;
	

	@Column(name = "EXPIRATION_DATE")
	private String expirationDate;
	
	@Column(name = "CVV_CODE")
	private String cvvCode;
	
	@Column(name = "CARD_HOLDER_NAME")
	private String cardHolderName;
	
	@Column(name = "CUSTOMER_ORDER_ID_FK")
	private int customerOrderId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID", insertable=false, updatable=false)
	private Order order;
	
	public PaymentInfo() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}