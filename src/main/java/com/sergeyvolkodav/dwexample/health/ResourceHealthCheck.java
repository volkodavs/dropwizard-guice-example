package com.sergeyvolkodav.dwexample.health;

import static javax.servlet.http.HttpServletResponse.SC_OK;

import com.hubspot.dropwizard.guice.InjectableHealthCheck;
import com.sergeyvolkodav.dwexample.config.HttpClientConfig;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Singleton
public class ResourceHealthCheck extends InjectableHealthCheck {

  private final Client client;

  @Inject
  public ResourceHealthCheck(HttpClientConfig httpClientConfig) {
    super();
    this.client = httpClientConfig.getClient();
  }

  @Override
  public String getName() {
    return "resource-health";
  }

  @Override
  protected Result check() {
    WebTarget webTarget = client.target("http://localhost:8080/fortune");
    Response response = webTarget.request().get();
    if (response.getStatus() == SC_OK) {
      return Result.healthy();
    }
    return Result.unhealthy("API failed!");
  }
}
