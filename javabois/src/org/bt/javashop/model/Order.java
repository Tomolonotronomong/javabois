package org.bt.javashop.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/**
 * A shopping cart holds a list of orders, and has an associated customer,
 * date of delivery and a unique id.
 *
 * Orders can be added, removed and retrieved from the cart, whilst it is
 * also possible to check the number of orders in the cart, clear its lineItems
 * and check if it is empty.
 *
 * The total cost of all orders in the cart can be retrieved, and an order can
 * be searched for by providing a product code.
 *
 * @author la
 */
public class Order implements Iterable<LineItem> {

	//fields
	private List<LineItem> lineItems;
	private Customer customer;
	private Date deliveryDate;
	private String cartId;


	//constructors
	public Order() {
		lineItems = new ArrayList<LineItem>();
		customer = new Customer();
		deliveryDate = new Date();
		cartId = "Not set";
	}

	public Order(Customer customer, Date deliveryDate, String cartId) {
		lineItems = new ArrayList<LineItem>();
		this.customer = customer;
		this.deliveryDate = deliveryDate;
		this.cartId = cartId;
	}


	//methods
	public void addOrder(LineItem o) {
		lineItems.add(o);
	}

	public void removeOrder(int i) {
		lineItems.remove(i);
	}

	public void clear() {
		lineItems.clear();
	}

	public LineItem getOrder(int i) {
		return lineItems.get(i);
	}

	public int numberOfOrders() {
		return lineItems.size();
	}

	public int getTotalCost() {
		int total = 0;
		for (LineItem o : lineItems) {
			total+= o.getCost();
		}
		return total;
	}

	public boolean isEmpty() {
		return lineItems.isEmpty();
	}

	public LineItem findOrder(String productCode) {
		for(LineItem o : lineItems) {
			if (o.getProduct().getProductCode().equals(productCode)) {
				return o;
			}
		}
		return null;
	}

	public void sortOrders() {
		Collections.sort(lineItems);
	}

	public boolean containsOrder(LineItem o) {
		return lineItems.contains(o);
	}

	public boolean removeOrder(LineItem o) {
		return lineItems.remove(o);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ":[lineItems=" + lineItems +
				", customer=" + customer +
				", deliveryDate=" + deliveryDate +
				", cartId=" + cartId + "]";
	}

	@Override
	public Iterator<LineItem> iterator() {
		return lineItems.iterator();
	}

}
