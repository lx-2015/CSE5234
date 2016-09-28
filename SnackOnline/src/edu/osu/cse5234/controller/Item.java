package edu.osu.cse5234.controller;

public class Item {
	private String name;
	private String quantity;
	
	public Item() {
		name = null;
		quantity = null;
	}
	
	public Item(String name, String quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
}
