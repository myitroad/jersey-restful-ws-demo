package com.demo.client;

import org.glassfish.jersey.media.sse.EventInput;
import org.glassfish.jersey.media.sse.InboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.io.IOException;

/**
 * Created by LTN on 2016/9/4.
 */
public class TestSse {

    @Test
    public void testSseResource() {
        Client client = ClientBuilder.newBuilder()
                .register(SseFeature.class).build();
        WebTarget target = client.target("http://localhost:8080/restfuldemo/services/events");

        EventInput eventInput = target.request().get(EventInput.class);
        while (!eventInput.isClosed()) {
            final InboundEvent inboundEvent = eventInput.read();
            if (inboundEvent == null) {
                // connection has been closed
                break;
            }
            System.out.println(inboundEvent.getName() + "; "
                    + inboundEvent.readData(String.class));
        }
    }
}