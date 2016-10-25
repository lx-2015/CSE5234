package edu.osu.cse5234.business.view;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

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
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK", insertable=false, updatable=false)
	private List<LineItem> lineItemList;
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK", insertable=false, updatable=false)
	private PaymentInfo paymentInfo;
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK", insertable=false, updatable=false)
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
