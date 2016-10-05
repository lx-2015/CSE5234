package edu.osu.cse5234.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomepageController {
	@RequestMapping(method = RequestMethod.GET)
	public String redirectToHomepage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Order order = new Order();
		List<Item> itemList = Arrays.asList(new Item("Dry Apple", "2.59", "0"), 
				new Item("Roasted Cashew", "5.99", "0"),
				new Item("Chocolate Bar", "1.99", "0"),
				new Item("Soft Candy", "0.99", "0"),
				new Item("Fried Chestnut", "2.99", "0"));
		order.setItemList(itemList);
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
