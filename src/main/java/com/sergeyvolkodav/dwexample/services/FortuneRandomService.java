package com.sergeyvolkodav.dwexample.services;

import com.sergeyvolkodav.dwexample.config.FortuneConfig;
import java.util.List;
import java.util.Random;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FortuneRandomService implements FortuneService {

  private final FortuneConfig fortune;
  private final Random random;

  @Inject
  public FortuneRandomService(FortuneConfig fortune) {
    this.fortune = fortune;
    this.random = new Random();
  }
  
  @Override
  public String getAnswer() {
    List<String> messages = fortune.getMessages();
    int randomElement = random.nextInt(messages.size());
    return messages.get(randomElement);
  }
}
