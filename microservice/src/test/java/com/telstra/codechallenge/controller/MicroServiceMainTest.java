package com.telstra.codechallenge.controller;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MicroServiceMainTest {

  @LocalServerPort
  private int port;

  @Autowired
  RestTemplate restTemplate = new RestTemplate();
/*
 @Test
  public void testHealth() throws RestClientException, MalformedURLException {
    ResponseEntity<String> response = restTemplate
        .getForEntity(new URL("http://localhost:8080" +  "/actuator/health")
            .toString(), String.class);
    assertEquals("{\"status\":\"UP\"}", response
        .getBody());
  }
 
 @Test
 public void testSearchRepositry() throws RestClientException, MalformedURLException {
   ResponseEntity<String> response = restTemplate
       .getForEntity(new URL("http://localhost:8080" +  "/search/repositories")
           .toString(), String.class);
   assertEquals("{\"status\":\"UP\"}", response
       .getBody());
 }*/
}
