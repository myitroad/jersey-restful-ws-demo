package com.demo.representation;

import com.demo.bean.Planet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by LTN on 2016/9/4.
 */
@Path("xmlType")
public class Resource {

    /**
     * /restfuldemo/services/xmlType/planet
     * @return
     * <planet>
            <id>1</id>
            <name>Earth</name>
            <radius>1.0</radius>
        </planet>
     */
    @GET
    @Path("planet")
    @Produces(MediaType.APPLICATION_XML)//try instead with @Produces("application/json")
    public Planet getPlanet() {
        final Planet planet = new Planet();

        planet.id = 1;
        planet.name = "Earth";
        planet.radius = 1.0;

        return planet;
    }
}