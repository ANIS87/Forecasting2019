package com.mycompany.model;

public class Weather {

	private String weatherDescriptions;
	private String windDegree;
	private String visibility;
	private String feelslike;
	private String windDir;
	private String pressure;
	private String cloudcover;
	private String precip;
	private String uvIndex;
	private String temperature;
	private String humidity;
	private String windSpeed;
	private String weatherCode;
	private String weatherIcons;

	public Weather() {

		this.weatherDescriptions = "";
		this.windDegree = "";
		this.visibility = "";
		this.feelslike = "";
		this.windDir = "";
		this.pressure = "";
		this.cloudcover = "";
		this.precip = "";
		this.uvIndex = "";
		this.temperature = "";
		this.humidity = "";
		this.windSpeed = "";
		this.weatherCode = "";
		this.weatherIcons = "";
	}

	@Override
	public String toString() {
		return "Weather [weatherDescriptions=" + weatherDescriptions + ", windDegree=" + windDegree + ", visibility="
				+ visibility + ", feelslike=" + feelslike + ", windDir=" + windDir + ", pressure=" + pressure
				+ ", cloudcover=" + cloudcover + ", precip=" + precip + ", uvIndex=" + uvIndex + ", temperature="
				+ temperature + ", humidity=" + humidity + ", windSpeed=" + windSpeed + ", weatherCode=" + weatherCode
				+ ", weatherIcons=" + weatherIcons + "]";
	}

	public String getWeatherDescriptions() {
		return weatherDescriptions;
	}

	public void setWeatherDescriptions(String weatherDescriptions) {
		this.weatherDescriptions = weatherDescriptions;
	}

	public String getWindDegree() {
		return windDegree;
	}

	public void setWindDegree(String windDegree) {
		this.windDegree = windDegree;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getFeelslike() {
		return feelslike;
	}

	public void setFeelslike(String feelslike) {
		this.feelslike = feelslike;
	}

	public String getWindDir() {
		return windDir;
	}

	public void setWindDir(String windDir) {
		this.windDir = windDir;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getCloudcover() {
		return cloudcover;
	}

	public void setCloudcover(String cloudcover) {
		this.cloudcover = cloudcover;
	}

	public String getPrecip() {
		return precip;
	}

	public void setPrecip(String precip) {
		this.precip = precip;
	}

	public String getUvIndex() {
		return uvIndex;
	}

	public void setUvIndex(String uvIndex) {
		this.uvIndex = uvIndex;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getWeatherCode() {
		return weatherCode;
	}

	public void setWeatherCode(String weatherCode) {
		this.weatherCode = weatherCode;
	}

	public String getWeatherIcons() {
		return weatherIcons;
	}

	public void setWeatherIcons(String weatherIcons) {
		this.weatherIcons = weatherIcons;
	}

}
