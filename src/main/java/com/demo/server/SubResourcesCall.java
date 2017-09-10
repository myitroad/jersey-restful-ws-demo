package com.demo.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by LTN on 2016/9/2.
 */
@Path("subResources")
public class SubResourcesCall {
    /**
     * http://localhost:8080/restfuldemo/services/subResources/getAddress
     * @return Address
     */
    @GET
    @Path("/getAddress")
    public Response getAddress() {
        return new SubAddrResources().getAddress();
    }
}

class SubAddrResources {
    public Response getAddress() {
        return Response
                .status(200)
                .entity("Address")
                .build();
    }
}

