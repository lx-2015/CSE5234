package edu.osu.cse5234.business.view;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER_ORDER_LINE_ITEM")
public class LineItem implements Serializable{

	private static final long serialVersionUID = -692455854174445341L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "ITEM_ID")
	private int itemNumber;
	
	@Column(name = "ITEM_NAME")
	private String name;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "CUSTOMER_ORDER_ID_FK")
	private int customerOrderId;
	
	@Transient
	private String description;
	
	@Transient
	private double price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID", insertable=false, updatable=false)
	private Order order;
	
	public LineItem() {

	}
	
	public LineItem(Item item) {
		id = item.getId();
		itemNumber = item.getItemNumber();
		name = item.getName();
		quantity = 0;
		
		description = item.getDescription();
		price = item.getPrice();
		order = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
