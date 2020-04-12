package com.sergeyvolkodav.dwexample.resources;

import com.sergeyvolkodav.dwexample.dtos.FortuneResponse;
import com.sergeyvolkodav.dwexample.services.FortuneService;
import com.sergeyvolkodav.dwexample.services.FortuneRandomService;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Singleton
@Produces(MediaType.APPLICATION_JSON)
@Path("/fortune")
public class FortuneResource {

  private final FortuneService fortuneService;

  @Inject
  public FortuneResource(FortuneService fortune) {
    this.fortuneService = fortune;
  }

  @GET
  public FortuneResponse askFortune() {
    return new FortuneResponse(fortuneService.getAnswer());
  }
}

