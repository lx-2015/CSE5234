package edu.osu.cse5234.business.view;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ITEM")
public class Item implements Serializable {

	private static final long serialVersionUID = -8834348079171772957L;
	private int id;
	private int itemNumber;
	private String name;
	private String description;
	private double price;
	private int quantity;
	
	public Item() {
		
	}
	
	public Item(int id, int itemNumber, String name, String description, double price, int quantity) {
		this.id = id;
		this.itemNumber = itemNumber;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
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
	
	@Column(name = "ITEM_NUMBER")
	public int getItemNumber() {
		return itemNumber;
	}
	
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "UNIT_PRICE")
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Column(name = "AVAILABLE_QUANTITY")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}