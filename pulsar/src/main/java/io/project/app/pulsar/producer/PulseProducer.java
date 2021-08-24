/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.pulsar.producer;

import io.github.majusko.pulsar.producer.PulsarTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author armena
 */
@Service
@Slf4j
public class PulseProducer {

    @Autowired
    private PulsarTemplate<String> producer;

    public String sendToPulse(String msg) {
        try {
            log.info("Sending message " + msg);
            MessageId send = producer.send("pulse", msg +"-" +System.currentTimeMillis());
            return send.toString();
        } catch (PulsarClientException ex) {
           log.error("error during sending "+ ex.getLocalizedMessage() );
        }
        return "No Id";
    }
}
