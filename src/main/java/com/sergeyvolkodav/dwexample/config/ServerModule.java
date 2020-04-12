package com.sergeyvolkodav.dwexample.config;

import com.google.inject.Binder;
import com.google.inject.Provides;
import com.hubspot.dropwizard.guicier.DropwizardAwareModule;
import com.sergeyvolkodav.dwexample.health.ResourceHealthCheck;
import com.sergeyvolkodav.dwexample.resources.FortuneResource;
import com.sergeyvolkodav.dwexample.services.FortuneRandomService;

public class ServerModule extends DropwizardAwareModule<AppConfig> {

  @Override
  public void configure(Binder binder) {
    // Bind
    binder.bind(FortuneResource.class);
    binder.bind(FortuneRandomService.class);
    binder.bind(HttpClientConfig.class);
//    binder.bind(FortuneRandomService.class).in(Singleton.class);

    // Bind extras
    binder.bind(ResourceHealthCheck.class);
  }

  @Provides
  public FortuneConfig provideFortune(AppConfig serverConfiguration) {
    return serverConfiguration.getFortune();
  }

}
