package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {
	List<Item> itemList;
    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
    	itemList = Arrays.asList(new Item("Dry Apple", "2.59", false, "10"), 
				new Item("Roasted Cashew", "5.99", false, "5"),
				new Item("Chocolate Bar", "1.99", false, "20"),
				new Item("Soft Candy", "0.99", false ,"30"),
				new Item("Fried Chestnut", "2.99", false ,"20"));
    }

	@Override
	public Inventory getAvailableInventory() {
		return new Inventory(itemList);
	}

	@Override
	public boolean validateQuantity(Collection<Item> items) {
		for (Item orderItem : items) {
			//if (orderItem.isSelected()) {
			if (Integer.parseInt(orderItem.getQuantity()) > 0) {
				for (Item inventoryItem : itemList) {
					if (orderItem.getName().equals(inventoryItem.getName())) {
						if (Integer.parseInt(orderItem.getQuantity()) > Integer.parseInt(inventoryItem.getQuantity())) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	@Override
	public boolean updateInventory(Collection<Item> items) {
		// Update the inventory
		for (Item orderItem : items) {
			//System.out.println(orderItem.getName() + " " + orderItem.isSelected());
			//if (orderItem.isSelected()) {
			if (Integer.parseInt(orderItem.getQuantity()) > 0) {
				for (Item inventoryItem : itemList) {
					if (orderItem.getName().equals(inventoryItem.getName())) {
						int orderQuantity = Integer.parseInt(orderItem.getQuantity());
						int inventoryQuantity =  Integer.parseInt(inventoryItem.getQuantity());
						inventoryItem.setQuantity(String.valueOf(inventoryQuantity - orderQuantity));
						System.out.println(inventoryItem.getName() + " New quantity is " +  inventoryItem.getQuantity());
					}
				}
			}
		}
		return true;
	}
}
