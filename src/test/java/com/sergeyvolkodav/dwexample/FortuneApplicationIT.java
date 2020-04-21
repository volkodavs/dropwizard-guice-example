package com.sergeyvolkodav.dwexample;

import com.sergeyvolkodav.dwexample.config.AppConfig;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.ClassRule;
import org.junit.Test;

public class FortuneApplicationIT {

  @ClassRule
  public static final DropwizardAppRule<AppConfig> RULE =
      new DropwizardAppRule<>(FortuneApplication.class, "app.yml");

  /**
   * Google guice wiring dependency at the runtime, so we
   * make an empty test to force dropwizard to start application
   * and perform DI validation
   */
  @Test
  public void test() {
  }
}