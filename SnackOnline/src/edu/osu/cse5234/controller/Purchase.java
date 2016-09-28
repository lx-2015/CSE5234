package edu.osu.cse5234.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/purchase")
public class Purchase {
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Order order = new Order();
		List<Item> itemList = Arrays.asList(new Item("Dry Apple", "0"), 
				new Item("Roasted Cashew", "0"),
				new Item("Chocolate Bar", "0"),
				new Item("Soft Candy", "0"),
				new Item("Fried Chestnut", "0"));
		order.setItemList(itemList);
		request.setAttribute("order", order);
		return "OrderEntryForm";
	}
	
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/paymentEntry";
	}
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("paymentInfo", new PaymentInfo());
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("paymentInfo") PaymentInfo paymentInfo, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("paymentInfo", paymentInfo);
		return "redirect:/purchase/shippingEntry";
	}
	
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String viewShippingEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("shippingInfo", new ShippingInfo());
		return "ShippingEntryForm";
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("shippingInfo", shippingInfo);
		return "redirect:/purchase/viewOrder";
	}
	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrderPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "ViewOrder";
	}
	
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/confirmation";
	}
	
	@RequestMapping(path = "/confirmation", method = RequestMethod.GET)
	public String viewConfirmationPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "Confirmation";
	}
}
