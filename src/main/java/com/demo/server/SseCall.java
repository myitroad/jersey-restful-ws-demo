package com.demo.server;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseBroadcaster;
import org.glassfish.jersey.media.sse.SseFeature;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by LTN on 2016/9/4.
 */
public class SseCall {
    private static final SseBroadcaster BROADCASTER = new SseBroadcaster();

    @GET
    @Path("sseEvents")
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput getConnection() {
        final EventOutput eventOutput = new EventOutput();
        BROADCASTER.add(eventOutput);
        return eventOutput;
    }

    @POST
    @Path("seePost")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void post(@FormParam("name") String name) {
        BROADCASTER
                .broadcast(new OutboundEvent.Builder()
                        .data(String.class, name)
                        .build());
    }
}
