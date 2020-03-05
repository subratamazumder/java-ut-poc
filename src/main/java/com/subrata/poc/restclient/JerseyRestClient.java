package com.subrata.poc.restclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyRestClient {
    public Object invoke() {
        PersonResponse output = null;
        try {

            Client client = Client.create();

            WebResource webResource = client
                    .resource("http://localhost:8080/wiremock/rest/json/post");

            ClientResponse response = webResource.type("application/json")
                    .post(ClientResponse.class, new PersonRequest("Subrata", 35));

            if (response.getStatus() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            System.out.println("Output from Server .... \n");
            System.out.println(response.getEntity(PersonResponse.class).getName());


        } catch (Exception e) {

            e.printStackTrace();

        }
        return output;

    }
}
