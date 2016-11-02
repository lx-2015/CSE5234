package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.business.view.LineItem;

import java.util.Collection;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {
	@PersistenceContext
	private EntityManager entityManager;
	private List<Item> itemList;
	private final String MY_QUERY = "Select i from Item i";
    public InventoryServiceBean() {
    	itemList = null;
    }

	@Override
	public Inventory getAvailableInventory() {
		itemList = entityManager.createQuery(MY_QUERY, Item.class).getResultList();
		return new Inventory(itemList);
	}

	@Override
	public boolean validateQuantity(Collection<LineItem> lineItems) {
		for (LineItem orderItem : lineItems) {
			if (orderItem.getQuantity() > 0) {
				for (Item inventoryItem : itemList) {
					if (orderItem.getName().equals(inventoryItem.getName())) {
						if (orderItem.getQuantity() > inventoryItem.getQuantity()) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	@Override
	public boolean updateInventory(Collection<LineItem> lineItems) {
		// Update the inventory
		// TODO: Also update the database to decrease quantities correspondingly
		for (LineItem orderItem : lineItems) {
			if (orderItem.getQuantity() > 0) {
				for (Item inventoryItem : itemList) {
					if (orderItem.getName().equals(inventoryItem.getName())) {
						int orderQuantity = orderItem.getQuantity();
						int inventoryQuantity =  inventoryItem.getQuantity();
						inventoryItem.setQuantity(inventoryQuantity - orderQuantity);
						System.out.println(inventoryItem.getName() + ". New quantity: " +  inventoryItem.getQuantity());
					}
				}
			}
		}
		return true;
	}
}
