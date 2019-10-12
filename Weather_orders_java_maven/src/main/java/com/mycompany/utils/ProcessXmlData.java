package com.mycompany.utils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.SAXException;

import com.mycompany.app.GetResponseApi;
import com.mycompany.model.Order;
import com.mycompany.model.Orders;
import com.mycompany.model.Weather;

public class ProcessXmlData {

	public static void parsefile(String filexml, String outFile) throws URISyntaxException {

		GetResponseApi getResponseApi = new GetResponseApi();
		StringBuilder data = new StringBuilder();
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		WriteInXml writeinxml = new WriteInXml();

		Orders orders = new Orders();
		try {

			SAXParser saxParser = saxParserFactory.newSAXParser();
			MyHandler handler = new MyHandler();
			saxParser.parse(new File(filexml), handler);
			List<Order> empList = handler.getEmpList();
			for (Order emp : empList) {
				Weather weatherResult = new Weather();
				JSONObject jsonObject = new JSONObject();
				jsonObject = getResponseApi.getJsonWeather(emp.toString());
				weatherResult = getResponseApi.createWeatherFromJson(jsonObject);
				emp.setWeather(weatherResult);
				orders.getOrders().add(emp);

				data.append(emp);
				data.append(";");
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		writeinxml.createXmlFIle(orders, outFile);
		
	}



}
