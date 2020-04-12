package com.sergeyvolkodav.dwexample.config;

import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import org.glassfish.jersey.client.JerseyClientBuilder;

@Singleton
public class HttpClientConfig {

  private final Client client;

  public HttpClientConfig() {
    client = new JerseyClientBuilder().build();
  }

  public Client getClient() {
    return client;
  }
}
