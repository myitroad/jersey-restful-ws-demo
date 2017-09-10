package com.demo.server;

import com.demo.bean.UserBean;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * Created by LTN on 2016/9/2.
 */
@Path("paramAnnotation")
public class ParamAnnotationCall {

    /**
     * /services/paramAnnotation/John
     *
     * @param name
     * @return
     */
    @GET
    @Path("{name}")
    public String getUserByName(@PathParam("name") String name) {
        return name;
    }

    /**
     * /services/paramAnnotation/query?name=John
     *
     * @param name
     * @return
     */
    @GET
    @Path("/query")
    public String getUser(@QueryParam("name") String name) {
        System.out.println("Name: " + name);
        return name;
    }

    /**
     * /services/paramAnnotation/queryParam?name=John
     * /services/paramAnnotation/queryParam?name=John&age=20
     *
     * @param name
     * @param age
     * @return
     */
    @GET
    @Path("/queryParam")
    public String getUser(@QueryParam("name") String name,
                          @DefaultValue("15") @QueryParam("age") String age) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        return name;
    }

    /**
     * /services/paramAnnotation/getUserById/1;name=John;age=10
     *
     * @param userId
     * @param name
     * @param age
     * @return
     */
    @GET
    @Path("/getUserById/{userId}")
    public Response getUserById(@PathParam("userId") String userId,
                                @MatrixParam("name") String name,
                                @DefaultValue("15") @MatrixParam("age") String age) {
        return Response
                .status(200)
                .entity("Id: " + userId + ", Name: " + name + ", Age: " + age)
                .build();
    }

    /**
     * /services/paramAnnotation/getUserAgent
     *
     * @param userAgent
     * @param contentType
     * @return
     */
    @GET
    @Path("/getUserAgent")
    public String getUserDevice(@HeaderParam("user-agent") String userAgent,
                                @HeaderParam("Content-Type") MediaType contentType) {
        return "User Agent: " + userAgent + ", Content-Type: " + contentType;
    }

    /**
     * /services/paramAnnotation/getCookies
     * @param sessionId
     * @return
     */
    @GET
    @Path("/getCookies")
    public String getCookies(@DefaultValue("10") @CookieParam("sessionid") int sessionId) {
        return "Session Id: " + sessionId;
    }

    /**
     * /services/paramAnnotation/getCookies2
     * @param
     * @return
     */
    /*@GET
    @Path("/getCookies2")
    public String getCookies(@CookieParam("user-agent") Cookie userAgentCookie) {
        return "Name: " + userAgentCookie.getName() +
                "Value: " + userAgentCookie.getValue() +
                "Domain: " + userAgentCookie.getDomain() +
                "Path: " + userAgentCookie.getPath() +
                "Version: " + userAgentCookie.getVersion();
    }
*/
    @POST
    @Path("/addUser")
    public void addUser(@FormParam("name") String name,
                        @FormParam("id") String id) {
        System.out.println("Add User:");
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
    }

    @POST
    @Path("/addUser2")
    public String addUser(MultivaluedMap<String, String> formData) {
        return "Form Data: " + formData;
    }

    /**
     * /services/paramAnnotation/getUserDetails/1;name=John;age=25?address=USA
     * @param userBean
     * @return 返回userBean toString()方法
     * User Bean: Id: 1 Name: John Age: 25 Address: USA
     * User Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.75 Safari/537.36
     */
    @GET
    @Path("/getUserDetails/{id}")
    public String getUser(@BeanParam UserBean userBean) {
        return "User Bean: " + userBean.toString();
    }

    @POST
    @Path("/usingFormParamWithConsume")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String greet(@FormParam("name") String name) {
        return "Hello, " + name;
    }

}
