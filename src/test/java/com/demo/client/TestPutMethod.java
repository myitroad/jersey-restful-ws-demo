package com.demo.client;

import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Created by LTN on 2016/9/2.
 */
public class TestPutMethod {
    @Test
    public void testPutMethod() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restfuldemo/services/methodsCall/putMethod");
        MultivaluedMap<String, String> putForm = new MultivaluedHashMap<String, String>();
        putForm.add("user","tom");
        String responseData = target.request().put(Entity.form(putForm),String.class);
        Assert.assertEquals(responseData,"user=tom");
    }

}
