/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.magnetar.consumer;

import io.github.majusko.pulsar.annotation.PulsarConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author armena
 */
@Service
@Slf4j
public class PulseConsumer {
    

    @PulsarConsumer(topic = "pulse", clazz = String.class)
    void consume(String msg) {
        log.info("Received " + msg);
        
     

    }
}
