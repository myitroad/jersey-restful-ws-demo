package com.demo.representation;

import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Created by LTN on 2016/9/2.
 */
public class TestJsonSupport {
    @Test
    public void testJaxbBean(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restfuldemo/services/jsonSupport");
        target = target.path("jaxbBean");
        Response response = target.request().get();
        String responseData = response.readEntity(String.class);
        System.out.println(responseData);
        Assert.assertNotNull(responseData);
    }

}
