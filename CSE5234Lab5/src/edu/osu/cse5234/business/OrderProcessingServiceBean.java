package edu.osu.cse5234.business;

import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.controller.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {
	@PersistenceContext
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }

    public String processOrder(Order order) {
    	InventoryService inventoryService = ServiceLocator.getInventoryService();
    	//inventoryService.updateInventory(order.getLineItemList());
    	entityManager.persist(order);
    	entityManager.flush();
    	// Generate a random number for the confirmation code
    	int max = 9999999;
    	int min = 1000000;
    	Random rand = new Random();
    	int randomNumber = rand.nextInt(max - min + 1) + min;
    	System.out.println(randomNumber);
    	return String.valueOf(randomNumber);
    }
    
    public boolean validateItemAvailability(Order order) {
    	InventoryService inventoryService = ServiceLocator.getInventoryService();
    	return inventoryService.validateQuantity(order.getLineItemList());
    }
}
