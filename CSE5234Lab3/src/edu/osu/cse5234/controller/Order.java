package edu.osu.cse5234.controller;

import java.util.*;

public class Order {
	private List<Item> itemList;
	
	public Order() {
		itemList = new ArrayList<Item>();
	}
	
	public List<Item> getItemList() {
		return itemList;
	}
	
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
}
