package com.mycompany.utils;

import java.io.FileOutputStream;
import java.io.IOException;

import com.mycompany.model.Order;
import com.mycompany.model.Orders;
import com.thoughtworks.xstream.XStream;

public class WriteInXml {

	public void saveOrders(String xml, String filename) {

		FileOutputStream fos = null;
		try {

			fos = new FileOutputStream(filename);
			fos.write("<?xml version=\"1.0\"?>".getBytes("UTF-8"));
			byte[] bytes = xml.getBytes("UTF-8");
			fos.write(bytes);
		} catch (Exception e) {
			System.err.println("Error in XML Write: " + e.getMessage());
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void createXmlFIle(Orders list, String filename) {
		XStream xstream = new XStream();
		xstream.alias("order", Order.class);
		xstream.alias("orders", Orders.class);
		xstream.addImplicitCollection(Orders.class, "orders");
		String xml = xstream.toXML(list);
		saveOrders(xml, filename);

	}

}
