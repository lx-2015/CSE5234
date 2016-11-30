package edu.osu.cse5234.controller;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import edu.osu.cse5234.business.view.LineItem;

@Entity
@Table(name = "CUSTOMER_ORDER")
public class Order implements Serializable {

	private static final long serialVersionUID = 8691984033721316339L;
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "ID")
	private int id;
	
	//@Column(name = "CUSTOMER_NAME")
	private String customerName;
	
	//@Column(name = "CUSTOMER_EMAIL")
	private String emailAddress;
	
	//@Column(name = "STATUS")
	private String status = "New";
	
	////@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name="CUSTOMER_ORDER_ID_FK", insertable=false, updatable=false)
	private List<LineItem> lineItemList;
	
	////@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="CUSTOMER_ORDER_ID_FK", insertable=false, updatable=false)
	private PaymentInfo paymentInfo;
	
	////@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="CUSTOMER_ORDER_ID_FK", insertable=false, updatable=false)
	private ShippingInfo shippingInfo;
	
	//@Transient
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "CUSTOMER_NAME")
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "CUSTOMER_EMAIL")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name="CUSTOMER_ORDER_ID_FK", insertable=false, updatable=false)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK")
	public List<LineItem> getLineItemList() {
		return lineItemList;
	}
	
	public void setLineItemList(List<LineItem> lineItemList) {
		this.lineItemList = lineItemList;
	}

	@Transient
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="CUSTOMER_ORDER_ID_FK", insertable=false, updatable=false)
	@JoinColumn(name="PAYMENT_INFO_ID_FK")
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="CUSTOMER_ORDER_ID_FK", insertable=false, updatable=false)
	@JoinColumn(name="SHIPPING_INFO_ID_FK")
	public ShippingInfo getShippingInfo() {
		return shippingInfo;
	}

	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
	}
	
	/*
	@PrePersist
	public void prePersistCallBack() {
		if (paymentInfo != null) {
			paymentInfo.setCustomerOrderId(id);
		}
		
		if (shippingInfo != null) {
			shippingInfo.setCustomerOrderId(id);
		}
	}
	*/
	public void removeZeroQuantityItems() {
		List<LineItem> newLineItemList = new ArrayList<LineItem>();
		for (LineItem lineItem : lineItemList) {
			if (lineItem.getQuantity() > 0) {
				newLineItemList.add(lineItem);
			}
		}
		lineItemList = newLineItemList;
	}
}
