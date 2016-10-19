package edu.osu.cse5234.controller;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import edu.osu.cse5234.business.view.LineItem;

@Entity
@Table(name = "CUSTOMER_ORDER")
public class Order implements Serializable {

	private static final long serialVersionUID = 8691984033721316339L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	
	@Column(name = "CUSTOMER_EMAIL")
	private String emailAddress;
	
	@Column(name = "STATUS")
	private String status;
	
	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name="CUSTOMER_ORDER_ID_FK")
	@Transient
	private List<LineItem> lineItemList;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK", insertable=false, updatable=false)
	private PaymentInfo paymentInfo;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="CUSTOMER_ORDER_ID_FK", insertable=false, updatable=false)
	@Transient
	private ShippingInfo shippingInfo;
	
	@Transient
	private boolean selected;
	
	public Order() {
		lineItemList = new ArrayList<LineItem>();
	}
	
	public Order(int id, String customerName, String emailAddress, String status, List<LineItem> lineItemList, boolean selected) {
		this.id = id;
		this.customerName = customerName;
		this.emailAddress = emailAddress;
		this.status = status;
		this.lineItemList = lineItemList;
		this.selected = selected;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<LineItem> getLineItemList() {
		return lineItemList;
	}
	
	public void setLineItemList(List<LineItem> lineItemList) {
		this.lineItemList = lineItemList;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public ShippingInfo getShippingInfo() {
		return shippingInfo;
	}

	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
	}
	
	@PrePersist
	public void prePersistCallBack() {
		if (paymentInfo != null) {
			paymentInfo.setCustomerOrderId(this.id);
		}
		
		if (shippingInfo != null) {
			shippingInfo.setCustomerOrderId(this.id);
		}
	}
}
