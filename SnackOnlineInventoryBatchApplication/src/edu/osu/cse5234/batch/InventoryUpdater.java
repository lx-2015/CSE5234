package edu.osu.cse5234.batch;

import java.sql.*;
import java.util.*;

public class InventoryUpdater {
	private static Connection createConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:~/SnackOnlineDB", "sa", "");
		return conn;
	}

	private static Collection<Integer> getNewOrders(Connection conn) throws SQLException {
		Collection<Integer> orderIds = new ArrayList<Integer>();
		ResultSet rset = conn.createStatement().executeQuery(
				"select ID from CUSTOMER_ORDER where STATUS = 'New'");
		while (rset.next()) {
			orderIds.add(new Integer(rset.getInt("ID")));
		}
		return orderIds;
	}

	private static Map<Integer, Integer> getOrderedLineItems(Collection<Integer> newOrderIds,
                Connection conn)  throws SQLException {
		// This method returns a map of two integers. The first Integer is item ID, and 
		// the second is cumulative requested quantity across all new orders
		Map<Integer, Integer> orderedItems = new HashMap<Integer, Integer>();
		for (Integer newOrderId : newOrderIds) {
			ResultSet rset = conn.createStatement().executeQuery(
	                "select ITEM_ID, QUANTITY from CUSTOMER_ORDER_LINE_ITEM"
	                + " where CUSTOMER_ORDER_ID_FK = " + newOrderId);
			while (rset.next()) {
				int itemId = new Integer(rset.getInt("ITEM_ID"));
				int quantity = new Integer(rset.getInt("QUANTITY"));
				if (!orderedItems.containsKey(itemId)) {
					orderedItems.put(itemId, quantity);
				} else {
					orderedItems.put(itemId, orderedItems.get(itemId) + quantity);
				}
			}
		}
		return orderedItems;
	}

	private static void udpateInventory(Map<Integer, Integer> orderedItems, 
                Connection conn) throws SQLException {
		for (Iterator<Map.Entry<Integer, Integer>> it = orderedItems.entrySet().iterator(); it.hasNext();) {
			Map.Entry<Integer, Integer> entry = it.next();
			int itemId = entry.getKey();
			int quantity = entry.getValue();
			conn.createStatement().execute(
					"update ITEM set AVAILABLE_QUANTITY = AVAILABLE_QUANTITY - " + quantity
					+ " where ITEM_NUMBER = " + itemId);
		}
	}

	private static void udpateOrderStatus(Collection<Integer> newOrderIds, 
                Connection conn) throws SQLException {
		conn.createStatement().execute(
				"update CUSTOMER_ORDER set STATUS = 'Processed'"
				+ " where STATUS = 'New'");
	}
	
	public static void main(String[] args) {

		System.out.println("Starting Inventory Update ...");
		try {
			Connection conn = createConnection();
			Collection<Integer> newOrderIds = getNewOrders(conn);
			Map<Integer, Integer> orderedItems = getOrderedLineItems(newOrderIds, conn);
			udpateInventory(orderedItems, conn);
			udpateOrderStatus(newOrderIds, conn);
			conn.close();
			//System.out.println("Inventory Update completed!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
