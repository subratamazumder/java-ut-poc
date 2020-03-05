package com.subrata.poc.restclient;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class JerseyRestClientTest {
    private static final String POST_RESOURCE ="/wiremock/rest/json/post";
    private static final int WIREMOCK_PORT=8080;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().port(WIREMOCK_PORT));
    JerseyRestClient jerseyRestClient;
    @Before
    public void setUp(){
        jerseyRestClient = new JerseyRestClient();
        stubFor(post(POST_RESOURCE)
                .willReturn(okJson("{ \"name\": \"subrata\", \"id\": \"123\" }").withStatus(201)));
    }

    @Test
    public void invoke() {
        System.out.println(jerseyRestClient.invoke(String.format("http://localhost:%s%s",WIREMOCK_PORT,POST_RESOURCE)));
        verify(postRequestedFor(urlEqualTo(POST_RESOURCE))
                .withHeader("Content-Type", equalTo("application/json")));

    }
}