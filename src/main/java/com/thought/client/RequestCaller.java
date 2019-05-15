package com.thought.client;

import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.client.urlconnection.URLConnectionClientHandler;
import com.thought.ConnectionFactory;
import com.thought.Constants;

public class RequestCaller {

	static Client client = null;

	public RequestCaller() {
		URLConnectionClientHandler ch = new URLConnectionClientHandler(new ConnectionFactory());
		client = new Client(ch);
	}

	public String getStatus() {
		String output = null;
		try {
			WebResource webResource = client.resource(Constants.URI);
			ClientResponse response = webResource.accept("application/json").header("userId", Constants.userID)
					.get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

	public String getInput() {
		String output = null;
		try {
			WebResource webResource = client.resource(Constants.CHALLENGE_INPUT_PATH);
			ClientResponse response = webResource.accept("application/json").header("userId", Constants.userID)
					.get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return output;

	}

	public String post(JSONObject input) {
		String output = null;
		try {
			WebResource webResource = client.resource(Constants.CHALLENGE_OUTPUT_PATH);
			ClientResponse response = webResource.accept("application/json").header("userId", Constants.userID)
					.type("application/json").post(ClientResponse.class, input);
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			System.out.println("Output from Server .... \n");
			output = response.getEntity(String.class);
			System.out.println(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

}