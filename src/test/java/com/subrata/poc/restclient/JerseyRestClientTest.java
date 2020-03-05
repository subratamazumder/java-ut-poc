package com.subrata.poc.restclient;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.Assert.*;

public class JerseyRestClientTest {
//    @ClassRule
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().port(8080));
    JerseyRestClient jerseyRestClient;
    @Before
    public void setUp() throws Exception {
        jerseyRestClient = new JerseyRestClient();
//        WireMockServer wm = new WireMockServer(options().port(8080));
        stubFor(post("/wiremock/rest/json/post")
                .willReturn(okJson("{ \"name\": \"subrata\", \"id\": \"123\" }").withStatus(201)));
    }

    @Test
    public void invoke() {
        System.out.println(jerseyRestClient.invoke());
        verify(postRequestedFor(urlEqualTo("/wiremock/rest/json/post"))
                .withHeader("Content-Type", equalTo("application/json")));
//

    }
}