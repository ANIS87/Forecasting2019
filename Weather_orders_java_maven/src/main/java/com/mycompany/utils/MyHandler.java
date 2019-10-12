package com.mycompany.utils;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.mycompany.model.Order;

public class MyHandler extends DefaultHandler {

	// List to hold Orders object
	private List<Order> empList = new ArrayList<Order>();
	private Order emp = new Order();
	private StringBuilder data = new StringBuilder();

	// getter method for Order list
	public List<Order> getEmpList() {
		return empList;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("order")) {

			// create a new Order and put it in Map
			String id = attributes.getValue("order-no");

			// initialize Order object and set id attribute
			emp = new Order();

			emp.setId(id);
			// initialize list
			if (empList == null)
				empList = new ArrayList<>();
		}
		// create the data container
		data = new StringBuilder();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if ("city".equalsIgnoreCase(qName)) {

			emp.setCity(data.toString());

		}

		if ("postal-code".equalsIgnoreCase(qName)) {
			emp.setcountryCode(data.toString());

		}

		if ("country-code".equalsIgnoreCase(qName)) {
			emp.setcountry(data.toString());

		}

		if (qName.equalsIgnoreCase("order")) {
			// add Order object to list
			empList.add(emp);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch, start, length));
	}
}
