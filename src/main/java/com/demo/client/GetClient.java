package com.demo.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Created by LTN on 2016/9/2.
 */
public class GetClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restfuldemo/services");
        target = target.path("helloWorld");
        Response response = target.request().get();
        String responseData = response.readEntity(String.class);
        System.out.println(responseData);
    }
}
