package com.demo.client;

import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Created by LTN on 2016/9/2.
 */
public class TestGetMethod {
    @Test
    public void testGet() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restfuldemo/services");
        target = target.path("helloWorld");
        Response response = target.request().get();
        String responseData = response.readEntity(String.class);
        Assert.assertEquals(responseData,"Hello World!!!");
    }

}
