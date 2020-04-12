package com.sergeyvolkodav.dwexample.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class ServerModule extends AbstractModule {

  @Provides
  public FortuneConfig provideFortune(AppConfig serverConfiguration) {
    return serverConfiguration.getFortune();
  }

}
