package edu.osu.cse5234.business.view;

import java.io.Serializable;

import javax.persistence.*;

//@Entity
//@Table(name = "CUSTOMER_ORDER_LINE_ITEM")
public class LineItem implements Serializable{

	private static final long serialVersionUID = -692455854174445341L;
	private int id;
	private int itemNumber;
	private String name;
	private int quantity;
	private int customerOrderId;
	
	private String description;
	private double price;
	
	public LineItem() {

	}
	
	public LineItem(Item item) {
		id = item.getId();
		itemNumber = item.getItemNumber();
		name = item.getName();
		quantity = 0;
		
		description = item.getDescription();
		price = item.getPrice();
	}

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//@Column(name = "ITEM_ID")
	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	//@Column(name = "ITEM_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//@Column(name = "QUANTITY")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//@Column(name = "CUSTOMER_ORDER_ID_FK")
	public int getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	//@Transient
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//@Transient
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
