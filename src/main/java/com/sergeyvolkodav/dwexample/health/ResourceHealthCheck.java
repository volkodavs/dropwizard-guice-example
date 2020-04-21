package com.sergeyvolkodav.dwexample.health;

import static javax.servlet.http.HttpServletResponse.SC_OK;

import com.codahale.metrics.health.HealthCheck;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ResourceHealthCheck extends HealthCheck {

  private final Client client;

  @Inject
  public ResourceHealthCheck(Client client) {
    super();
    this.client = client;
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
