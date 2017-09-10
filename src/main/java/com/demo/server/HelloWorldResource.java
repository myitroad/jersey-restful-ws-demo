package com.demo.server;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by LTN on 2016/9/1.
 */
@Path("helloWorld")
@Produces("text/plain")
public class HelloWorldResource{

    /**
     * http://localhost:8080/restfuldemo/services/helloWorld
     * @return Hello World!!!
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greet(){
        return "Hello World!!!";
    }

    /**
     * http://localhost:8080/restfuldemo/services/helloWorld/jerry
     * @param name
     * @return Hello jerry
     */
    @GET
    @Path("{name}")
    public String greetName(@PathParam(value = "name") String name) {
        return "Hello "+name;
    }

    /**
     * 只匹配英文字母的名字，否则报错
     * http://localhost:8080/restfuldemo/services/helloWorld/regName/marilin   可以测试通过
     * http://localhost:8080/restfuldemo/services/helloWorld/regName/marilin.kai 测试不可通过
     * @param name
     * @return
     */
    @GET
    @Path("regName/{name: ([a-zA-Z])*}")
    public String sayHello(@PathParam("name") String name) {
        return "Hello, " + name;
    }

}