package io.swagger.rabbitmq.consumer;

import io.swagger.model.LiftRide;
import io.swagger.repository.SkierRepository;
import java.util.concurrent.CountDownLatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageReceiver {

  private final SkierRepository skierRepository;

  private CountDownLatch latch = new CountDownLatch(1);

  @Autowired
  public MessageReceiver(SkierRepository skierRepository) {
    this.skierRepository = skierRepository;
  }

  @RabbitListener(queues="skier-queue", containerFactory="srlcFactory")
  public void messageHandler(LiftRide liftRide) {
    log.info("RABBITMQ    |   received <" + liftRide.toString() + ">");

    skierRepository.writeNewLiftRide(liftRide);
  }

  public CountDownLatch getLatch() {
    return this.latch;
  }
}
