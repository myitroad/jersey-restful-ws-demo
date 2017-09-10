package com.demo.representation;

import com.demo.bean.DataStructure;
import com.demo.bean.MyJaxbBean;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LTN on 2016/9/2.
 */
@Path("jsonSupport")
public class JSONSupport {

    /**
     * http://localhost:8080/restfuldemo/services/jsonSupport/jaxbBean?name=HanMei&age=11
     * @param name
     * @param age
     * @return
     * {
        "name": "HanMei",
        "age": 11
        }
     */
    @GET
    @Path("jaxbBean")
    @Produces("application/json")//try instead with @Produces(MediaType.APPLICATION_XML)
    public MyJaxbBean getMyBean(@QueryParam(value="name")String name,
                                @QueryParam(value="age")int age){
        return new MyJaxbBean(name, age);
    }

    @GET
    @Path("dataStructure")
    @Produces("application/json")
    public DataStructure getDataStructure() {
        List<Map<String,String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Lisa");
        map.put("age", "25");
        list.add(map);
        Map<String, String> map2 = new HashMap<>();
        map2.put("name", "Sara");
        map2.put("age", "33");
        list.add(map2);
        return new DataStructure(list);
    }
}
