package com.sergeyvolkodav.dwexample.config;

import io.dropwizard.Configuration;

public class AppConfig extends Configuration {

  private FortuneConfig fortune;

  public FortuneConfig getFortune() {
    return fortune;
  }
}
