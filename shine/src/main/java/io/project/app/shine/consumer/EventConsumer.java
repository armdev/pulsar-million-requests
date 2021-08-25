/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.shine.consumer;

import io.github.majusko.pulsar.annotation.PulsarConsumer;
import io.project.app.shine.services.ShineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author armena
 */
@Service
@Slf4j
public class EventConsumer {

    @Autowired
    private ShineService shineService;

    @PulsarConsumer(topic = "redline", clazz = String.class)
    void consume(String msg) {
        log.info("Received Event " + msg);
        shineService.saveFromStream(msg);

    }
}
