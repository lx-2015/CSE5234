package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.util.ServiceLocator;

@Controller
@RequestMapping("/")
public class HomepageController {
	@RequestMapping(method = RequestMethod.GET)
	public String redirectToHomepage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		InventoryService inventoryService = ServiceLocator.getInventoryService();
		Inventory inventory = inventoryService.getAvailableInventory();
		request.setAttribute("inventory", inventory);
		Order order = new Order(inventory.getEmptyItemList());
		request.setAttribute("order", order);
		return "home";
	}
	
	@RequestMapping(path = "/AboutUs", method = RequestMethod.GET)
	public String contactUs() throws Exception {
		return "AboutUs";
	}
	
	@RequestMapping(path = "/ContactUs", method = RequestMethod.GET)
	public String aboutUs() throws Exception {
		return "ContactUs";
	}
}
