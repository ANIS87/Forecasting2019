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
public class ParseXmlFile {
	
        
	    public static Map<String,String> parsefile(String filexml,String outFile) throws URISyntaxException {
	    
	    GetResponseApi getResponseApi=new GetResponseApi();
	    Map<String,String> mapLocations = new HashMap<String, String>();
	    StringBuilder data = new StringBuilder();
	    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	    WriteInXml writeinxml=new WriteInXml();
	   
	    Orders orders = new Orders ();
	    try {
	    	int i=0;
	    	
	        SAXParser saxParser = saxParserFactory.newSAXParser();
	        MyHandler handler = new MyHandler();
	        saxParser.parse(new File(filexml), handler);	        
	        List<Order> empList = handler.getEmpList();	     
	        for(Order emp : empList)
	        {   
	        	Weather weatherResult=new Weather ();	        	
	        	JSONObject jsonObject=new JSONObject();	
	        	jsonObject =getResponseApi.getJsonWeather(emp.toString());	        	
	        	weatherResult=createWeatherFromJson(jsonObject);
	        	emp.setWeather(weatherResult);
	        	orders.getOrders().add(emp);	        	
	            
	        	data.append(emp);
	        	data.append(";");
	        	mapLocations.put(emp.getId(),emp.toString());
	        }
	      
	    } catch (ParserConfigurationException | SAXException | IOException e) {
	        e.printStackTrace();
	    }
	    
	    
	    writeinxml.createXmlFIle(orders,outFile);
	    return mapLocations;
	    }

	    public static Weather createWeatherFromJson(JSONObject jsonObject)
	    {   Weather weatherResult=new Weather ();
	    
	        try
	        {
	    	String weatherDescriptions=String.valueOf(jsonObject.getJSONObject("current").getJSONArray("weather_descriptions").get(0));
	    	weatherResult.setWeatherDescriptions(weatherDescriptions);
	    	String windDegree=String.valueOf(jsonObject.getJSONObject("current").getInt("wind_degree"));
	    	weatherResult.setWindDegree(windDegree);
	    	String visibility=String.valueOf(jsonObject.getJSONObject("current").getInt("visibility"));	 
	    	weatherResult.setVisibility(visibility);
	    	String feelslike=String.valueOf(jsonObject.getJSONObject("current").getInt("feelslike"));
	    	weatherResult.setFeelslike(feelslike);
	    	String windDir=String.valueOf(jsonObject.getJSONObject("current").getString("wind_dir"));
	    	weatherResult.setWindDir(windDir);
	    	String pressure=String.valueOf(jsonObject.getJSONObject("current").getInt("pressure"));
	    	weatherResult.setPressure(pressure);
	    	String cloudcover=String.valueOf(jsonObject.getJSONObject("current").getInt("cloudcover"));
	    	weatherResult.setCloudcover(cloudcover);
	    	String precip=String.valueOf(jsonObject.getJSONObject("current").getInt("precip"));
	    	weatherResult.setPrecip(precip);
	    	String uvIndex=String.valueOf(jsonObject.getJSONObject("current").getInt("uv_index"));
	    	weatherResult.setUvIndex(uvIndex);
	    	String temperature=String.valueOf(jsonObject.getJSONObject("current").getInt("temperature"));
	    	weatherResult.setTemperature(temperature);
	    	String humidity=String.valueOf(jsonObject.getJSONObject("current").getInt("humidity"));
	    	weatherResult.setHumidity(humidity);
	    	String windSpeed=String.valueOf(jsonObject.getJSONObject("current").getInt("wind_speed"));
	    	weatherResult.setWindSpeed(windSpeed);
	    	String weatherCode=String.valueOf(jsonObject.getJSONObject("current").getInt("weather_code"));
	    	weatherResult.setWeatherCode(weatherCode);
	    	String weatherIcons=String.valueOf(jsonObject.getJSONObject("current").getJSONArray("weather_icons").get(0));
	    	weatherResult.setWeatherIcons(weatherIcons);
	        }  catch (JSONException e) 
	        {
	        	System.out.println("on ne peut pas lire le json");
	        }
	        
	    	return weatherResult;
	    	
	    	
	    }
	 
	   

}
