package com.demo.bean;

import javax.ws.rs.*;

/**
 * Created by LTN on 2016/9/2.
 */
public class UserBean {
    @PathParam("id")
    private String id;
    @MatrixParam("name")
    private String name;
    @MatrixParam("age")
    private String age;
    @DefaultValue("No address provided")
    @QueryParam("address")
    private String address;
    @HeaderParam("user-agent")
    private String userAgent;
    public String toString(){
        return "Id: " + id +
                ",Name: " + name +
                ",Age: " + age +
                ",Address: " + address ;
    }
}
