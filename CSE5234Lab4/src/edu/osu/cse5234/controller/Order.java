package edu.osu.cse5234.controller;

import java.io.Serializable;
import java.util.*;

import edu.osu.cse5234.business.view.Item;

public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8691984033721316339L;
	private List<Item> itemList;
	
	public Order() {
		itemList = new ArrayList<Item>();
	}
	
	public Order(List<Item> itemList) {
		this.itemList = itemList;
	}
	
	public List<Item> getItemList() {
		return itemList;
	}
	
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
}
