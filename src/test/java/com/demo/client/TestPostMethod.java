package com.demo.client;

import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * Created by LTN on 2016/9/2.
 */
public class TestPostMethod {
    @Test
    public void testPostMethod() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restfuldemo/services/methodsCall/postMethod2");
        MultivaluedMap<String, String> postForm = new MultivaluedHashMap<String, String>();
        postForm.add("id","1");
        postForm.add("name", "John");
        String responseData = target
                .request()
                .post(Entity.form(postForm), String.class);
        Assert.assertEquals(responseData, "User added successfully.");
    }

}
