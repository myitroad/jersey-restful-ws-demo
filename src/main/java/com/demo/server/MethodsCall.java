package com.demo.server;

import javax.ws.rs.*;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Created by LTN on 2016/9/2.
 */
@Path("methodsCall")
@Produces("text/plain")
public class MethodsCall {

    /**
     * http://localhost:8080/restfuldemo/services/methodsCall/getMethod
     * @return Hello User
     */
    @Path("getMethod")
    @GET
    public String getUser() {
        System.out.println("GET");
        return "Hello User";
    }

    /**
     * 使用SOUPUI测试通过
     * @param userData
     */
    @Path("putMethod")
    @PUT
    public String updateUser(String userData) {
        System.out.println("PUT");
        System.out.println("User Data: " + userData);
        return userData;
    }

    /**
     * 使用SOUPUI测试通过
     * @param id
     * @param name
     */
    @Path("postMethod")
    @POST
    public void addUser(@FormParam("id") String id, @FormParam("name") String name){
        System.out.println("POST");
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
    }

    /**
     * 使用SOUPUI测试通过
     * @param formData
     * @return
     */
    @Path("postMethod2")
    @POST
    public String addUser(MultivaluedMap<String, String> formData) {
        System.out.println("Form Data: " + formData);
        return "User added successfully.";
    }

    /**
     * 使用SOUPUI测试通过
     * @param name
     */
    @DELETE
    @Path("deleteMethod/{name}")
    public String delete(@PathParam("name")String name) {
        System.out.println("DELETE: " + name);
        return name;
    }

    @GET
    @Produces({"application/json"})
    @Path("jsonType")
    public String jsonType() {
        return "{\"id\":\"1\",\"name\":\"kitty\"}";
    }

    @GET
    @Produces({"application/xml"})
    @Path("xmlType")
    public String xmlType() {
        return "<nodes type='parent'><node>child1</node></nodes>";
    }
}
