package io.project.app.magnetar.consumer;

import io.github.majusko.pulsar.annotation.PulsarConsumer;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.SubscriptionType;
import org.springframework.stereotype.Service;

/**
 *
 * @author armena
 */
@Service
@Slf4j
public class PulseConsumer {

    @PulsarConsumer(topic = "pulse", subscriptionType = SubscriptionType.Shared, clazz = String.class)
    void consume(String msg) {
        log.info("Received " + msg);
    }

    @PulsarConsumer(topic = "example-string-topic", subscriptionType = SubscriptionType.Shared, clazz = String.class)
    void consumeNew(String msg) {
        log.info("Received from example topic " + msg);

    }
}
