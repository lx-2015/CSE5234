package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.business.OrderProcessingServiceBean;
import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.business.view.LineItem;
import edu.osu.cse5234.business.view.Order;
import edu.osu.cse5234.business.view.PaymentInfo;
import edu.osu.cse5234.business.view.ShippingInfo;
import edu.osu.cse5234.util.ServiceLocator;

@Controller
@RequestMapping("/purchase")
public class Purchase {
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewLoginPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Order order = new Order();
		request.setAttribute("order", order);
		return "LoginForm";
	}
	
	@RequestMapping(path = "/submitLogin", method = RequestMethod.POST)
	public String submitLogin(@ModelAttribute("order") Order order, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/orderEntry";
	}
	
	@RequestMapping(path = "/orderEntry", method = RequestMethod.GET)
	public String viewOrderEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Order order = (Order)request.getSession().getAttribute("order");
		InventoryService inventoryService = ServiceLocator.getInventoryService();
		Inventory inventory = inventoryService.getAvailableInventory();
		List<Item> itemList = inventory.getItemList();
		List<LineItem> lineItemList = new ArrayList<LineItem>();
		for (Item item : itemList) {
			LineItem lineItem = new LineItem(item);
			lineItem.setCustomerOrderId(order.getId());
			lineItemList.add(lineItem);
		}
		order.setLineItemList(lineItemList);
		request.getSession().setAttribute("order", order);
		return "OrderEntryForm";
	}
	
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) throws Exception {
		// order1 contains customer name and email address, while order contains other information
		Order order1 = (Order)request.getSession().getAttribute("order");
		order.setCustomerName(order1.getCustomerName());
		order.setEmailAddress(order1.getEmailAddress());
		request.getSession().setAttribute("order", order);
		OrderProcessingServiceBean orderProcessingServiceBean = ServiceLocator.getOrderProcessingService();
		if (orderProcessingServiceBean.validateItemAvailability(order)) {
			request.getSession().setAttribute("valid", true);
			return "redirect:/purchase/paymentEntry";
		} else {
			request.getSession().setAttribute("valid", false);
			return "redirect:/";
		}
	}
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("paymentInfo", new PaymentInfo());
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("paymentInfo") PaymentInfo paymentInfo, HttpServletRequest request) throws Exception {
		Order order = (Order)request.getSession().getAttribute("order");
		order.setPaymentInfo(paymentInfo);
		request.getSession().setAttribute("order", order);
		paymentInfo.setOrder(order);
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
		Order order = (Order)request.getSession().getAttribute("order");
		request.getSession().setAttribute("shippingInfo", shippingInfo);
		order.setShippingInfo(shippingInfo);
		shippingInfo.setOrder(order);
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/viewOrder";
	}
	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrderPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "ViewOrder";
	}
	
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	//public String confirmOrder(@ModelAttribute("order") Order order, HttpServletRequest request) {
	public String confirmOrder(HttpServletRequest request) {
		Order order = (Order)request.getSession().getAttribute("order");
		//request.getSession().setAttribute("order", order);
		OrderProcessingServiceBean orderProcessingServiceBean = ServiceLocator.getOrderProcessingService();
		String confirmationCode = orderProcessingServiceBean.processOrder(order);
		request.getSession().setAttribute("confirmationCode", confirmationCode);
		return "redirect:/purchase/confirmation";
	}
	
	@RequestMapping(path = "/confirmation", method = RequestMethod.GET)
	public String viewConfirmationPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "Confirmation";
	}
}
