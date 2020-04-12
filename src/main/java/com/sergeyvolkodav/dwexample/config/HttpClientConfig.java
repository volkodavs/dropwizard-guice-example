package com.sergeyvolkodav.dwexample.config;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import org.glassfish.jersey.client.JerseyClientBuilder;

@Singleton
public class HttpClientConfig {

  private final Client client;

  @Inject
  public HttpClientConfig() {
    client = new JerseyClientBuilder().build();
  }

  public Client getClient() {
    return client;
  }
}
