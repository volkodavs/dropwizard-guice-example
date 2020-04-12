package com.sergeyvolkodav.dwexample.config;

import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;

public class FortuneConfig {

  @NotEmpty
  private List<String> messages;

  public List<String> getMessages() {
    return messages;
  }
}
