package com.rest.webservice;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RunningStatus {
	
	public static void main(String[] args) {
		

		Client client = ClientBuilder.newClient();
		
		WebTarget webresource = client.target("https://api.openweathermap.org/data/2.5/weather");
		
		WebTarget webresourcequery =webresource.queryParam("apikey", "your_apikey").queryParam("q", "new delhi");
		
	     Invocation.Builder invocationBuilder =
	    		 webresourcequery.request(MediaType.APPLICATION_JSON);	
	     Response response = invocationBuilder.get();
	     System.out.println(response.getStatus());
	     System.out.println(response.readEntity(String.class));
	}

}
