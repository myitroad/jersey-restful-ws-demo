package com.demo.client;

import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * Created by LTN on 2016/9/2.
 */
public class TestDeleteMethod {
    @Test
    public void testDeleteMethod() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restfuldemo/services/methodsCall/deleteMethod/peter");
        String responseData=target.request().delete(String.class);
        Assert.assertEquals(responseData,"peter");
    }
}
