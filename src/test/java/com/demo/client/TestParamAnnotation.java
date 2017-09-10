package com.demo.client;

import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Created by LTN on 2016/9/2.
 */
public class TestParamAnnotation {
    @Test
    public void testPathParam() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restfuldemo/services/paramAnnotation");
        String responseData = target
                .path("{name}")
                .resolveTemplate("name", "John")
                .request()
                .get(String.class);
        Assert.assertEquals(responseData, "John");
    }

    @Test
    public void testQueryParam() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restfuldemo/services/paramAnnotation");
        String responseData = target
                .path("query")
                .queryParam("name", "John")
                .request().get(String.class);
        Assert.assertEquals(responseData, "John");
    }

    @Test
    public void testCookieParam() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restfuldemo/services/paramAnnotation/getCookies");
        Cookie cookie = new Cookie("sessionid", "100");
        String responseData = target.request().cookie(cookie).get(String.class);
        Assert.assertEquals(responseData, "Session Id: 100");
    }

    @Test
    public void testMatrixParam() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restfuldemo/services/paramAnnotation");
        MultivaluedMap<String, String> postForm = new MultivaluedHashMap<String, String>();
        postForm.add("id", "1");
        postForm.add("name", "John");
        postForm.add("age", "22");
        String responseData = target
                .path("addUser2")
                .request()
                .post(Entity.form(postForm), String.class);
        Assert.assertEquals(responseData, "Form Data: {id=[1], name=[John], age=[22]}");
    }

    @Test
    public void testBeanParam() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restfuldemo/services/paramAnnotation/getUserDetails");
        String responseData = target
                .path("{id}")
                .resolveTemplate("id", "1001")
                .matrixParam("name", "John")
                .matrixParam("age", 25)
                .queryParam("address", "USA")
                .request()
                .get(String.class);
        Assert.assertEquals(responseData,"User Bean: Id: 1001,Name: John,Age: 25,Address: USA");
    }

    @Test
    public void testProducesParam() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restfuldemo/services/methodsCall/xmlType");
        String responseData = target.request(MediaType.APPLICATION_XML).get(String.class);
        Assert.assertEquals(responseData,"<nodes type='parent'><node>child1</node></nodes>");
    }

    @Test
    public void testConsumesParam() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restfuldemo/services/paramAnnotation/usingFormParamWithConsume");
        MultivaluedMap<String, String> postForm = new MultivaluedHashMap<String, String>();
        postForm.add("name","pheonix");
        String responseData = target
                .request()
                .accept(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .post(Entity.form(postForm),String.class) ;
        Assert.assertEquals(responseData,"Hello, pheonix");
    }

}
