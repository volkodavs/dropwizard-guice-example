package com.sergeyvolkodav.dwexample.config;

import com.google.inject.Binder;
import com.google.inject.Provides;
import javax.inject.Singleton;
import com.hubspot.dropwizard.guicier.DropwizardAwareModule;
import com.sergeyvolkodav.dwexample.health.ResourceHealthCheck;
import com.sergeyvolkodav.dwexample.resources.FortuneResource;
import com.sergeyvolkodav.dwexample.services.FortuneRandomService;
import com.sergeyvolkodav.dwexample.services.FortuneService;

public class ServerModule extends DropwizardAwareModule<AppConfig> {

  @Override
  public void configure(Binder binder) {
    // Binding
    binder.bind(FortuneResource.class).in(Singleton.class);
    binder.bind(HttpClientConfig.class).in(Singleton.class);
    binder.bind(FortuneService.class).to(FortuneRandomService.class).in(Singleton.class);

    // Bind extras
    binder.bind(ResourceHealthCheck.class).in(Singleton.class);
  }

  @Provides
  public FortuneConfig provideFortune(AppConfig serverConfiguration) {
    return serverConfiguration.getFortune();
  }

}
