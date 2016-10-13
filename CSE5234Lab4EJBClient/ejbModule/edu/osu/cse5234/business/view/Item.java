package edu.osu.cse5234.business.view;

import java.io.Serializable;

public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8834348079171772957L;
	private String name;
	private String price;
	private boolean selected;
	private String quantity;
	
	public Item() {
		name = null;
		price = null;
		selected = false;
		quantity = null;
	}
	
	public Item(String name, String price, boolean selected, String quantity) {
		this.name = name;
		this.price = price;
		this.selected = selected;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}