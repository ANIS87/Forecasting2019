package com.mycompany.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Orders { // @XmlElementWrapper(name = "orders")
						// @XmlElement(name = "order")
	private List<Order> orders = new ArrayList<>();

	// private List<Order> orders;
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void addBook(Order book) {
		try {
			if (orders == null) {
				orders = new ArrayList<Order>();
			}
			orders.add(book);

		} catch (Exception e) {
		}
	}

}