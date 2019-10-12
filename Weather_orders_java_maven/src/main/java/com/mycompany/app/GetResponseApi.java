package com.mycompany.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class GetResponseApi {

	// essential URL structure is built using constants
	public static final String ACCESS_KEY = "YOUR_PRIVATE_KEY";
	public static final String BASE_URL = "http://api.weatherstack.com/";
	public static final String ENDPOINT = "/current";
	public static final boolean bulkqueries = false;
	// this object is used for executing requests to the (REST) API
	static CloseableHttpClient httpClient = HttpClients.createDefault();

	// sendLiveRequest() function is created to request and retrieve the data
	@SuppressWarnings("deprecation")
	public static void sendLiveRequest(Map<String, String> data) throws URISyntaxException {

		Map<String, URI> allLocations = getUri(data);
		Iterator<Map.Entry<String, URI>> it = allLocations.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, URI> pair = it.next();
			// URI uri=getUri(locations);
			HttpGet get = new HttpGet(pair.getValue());
			try {

				CloseableHttpResponse response = httpClient.execute(get);
				HttpEntity entity = response.getEntity();

				JSONObject jsonObject = new JSONObject(EntityUtils.toString(entity));
				System.out.println(jsonObject.toString());

				response.close();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@SuppressWarnings("deprecation")
	public static JSONObject getJsonWeather(String data) throws URISyntaxException {

		URI url = getSingleUri(data);
		JSONObject jsonObject = new JSONObject();
		HttpGet get = new HttpGet(url);
		try {

			CloseableHttpResponse response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();

			jsonObject = new JSONObject(EntityUtils.toString(entity));

			response.close();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

	// sendLiveRequest() function is executed
	public void getdata(Map<String, String> data) throws IOException, URISyntaxException {
		sendLiveRequest(data);
		httpClient.close();
		new BufferedReader(new InputStreamReader(System.in)).readLine();
	}

	public static Map<String, URI> getUri(Map<String, String> data) throws URISyntaxException {
		// String location="Norfolk County,Plainville,02762,US";
		String location = "";
		Map<String, URI> mapLocations = new HashMap<String, URI>();
		Iterator<Map.Entry<String, String>> it = data.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> pair = it.next();
			location = pair.getValue();
			URIBuilder builder = new URIBuilder();
			builder.setScheme("http").setHost("api.weatherstack.com").setPath(ENDPOINT)
					.setParameter("access_key", ACCESS_KEY).setParameter("query", location);
			// .setParameter("query", QUERY);
			URI uri = builder.build();
			mapLocations.put(pair.getKey(), uri);
		}
		return mapLocations;

	}

	public static URI getSingleUri(String location) throws URISyntaxException {

		URIBuilder builder = new URIBuilder();
		builder.setScheme("http").setHost("api.weatherstack.com").setPath(ENDPOINT)
				.setParameter("access_key", ACCESS_KEY).setParameter("query", location);
		// .setParameter("query", QUERY);
		URI uri = builder.build();
		return uri;

	}

}
