package com.mycompany.model;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name = "order")
//@XmlType(propOrder = { "orderNo", "country" })

public class Order {

	private String orderNo;
	private String city;
	private String cityCode;
	private String country;
	private Weather weather;

	public String getId() {
		return orderNo;
	}

	public void setId(String id) {
		this.orderNo = id;
	}

	// @XmlElement(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getcountryCode() {
		return cityCode;
	}

	public void setcountryCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getcountry() {
		return country;
	}

	public void setcountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		/*
		 * return "Employee:: ID="+this.orderNo+" city=" + this.city + " counrycode=" +
		 * this.cityCode + " country=" + this.country;
		 */
		return this.city + "," + this.cityCode + "," + this.country;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public Order() {
		this.orderNo = "test";
		this.city = "test";
		this.cityCode = "test";
		this.country = "test";
		this.weather = new Weather();
	}

}
