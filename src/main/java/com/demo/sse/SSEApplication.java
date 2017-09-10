package com.demo.sse;

import org.glassfish.jersey.media.sse.SseFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by LTN on 2016/9/4.
 */
@ApplicationPath("services")
public class SSEApplication extends ResourceConfig {
    public SSEApplication() {
        super(SseFeature.class);
    }
}