package com.sergeyvolkodav.dwexample;

import com.hubspot.dropwizard.guicier.GuiceBundle;
import com.sergeyvolkodav.dwexample.config.AppConfig;
import com.sergeyvolkodav.dwexample.config.ServerModule;
import io.dropwizard.Application;
import io.dropwizard.configuration.ConfigurationSourceProvider;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class FortuneApplication extends Application<AppConfig> {

  @Override
  public String getName() {
    return "fortune-app";
  }

  @Override
  public void initialize(Bootstrap<AppConfig> bootstrap) {
    ConfigurationSourceProvider sourceProvider = new SubstitutingSourceProvider(
        new ResourceConfigurationSourceProvider(),
        new EnvironmentVariableSubstitutor(false)
    );
    bootstrap.setConfigurationSourceProvider(sourceProvider);

    GuiceBundle<AppConfig> guiceBundle = GuiceBundle.defaultBuilder(AppConfig.class)
        .modules(new ServerModule())
        .build();
    bootstrap.addBundle(guiceBundle);
  }

  @Override
  public void run(AppConfig configuration, Environment environment) {
  }

  public static void main(String... args) throws Exception {
    if (args == null || args.length == 0) {
      args = new String[]{"server", "app.yml"};
    }
    new FortuneApplication().run(args);
  }
}
