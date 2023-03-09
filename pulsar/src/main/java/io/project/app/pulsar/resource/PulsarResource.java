/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.pulsar.resource;

import io.project.app.pulsar.producer.PulseProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author armena
 */
@RestController
@RequestMapping("/api/v2/pulsars")
public class PulsarResource {

    @Autowired
    private PulseProducer pulseProducer;

    @GetMapping("/send")
    public String sendToPulsar(@RequestParam String message) {

        return pulseProducer.sendToPulse(message);

    }

    @GetMapping("/send/ping")
    public String ping() {

        return pulseProducer.ping();

    }

    @GetMapping("/send/json")
    public String sendToPulsarToJson() {

        return pulseProducer.sendToPulseJson();
    }

    @GetMapping("/send/data/event")
    public String send() {

        pulseProducer.sendToPulseEventChannel();
        return "sent";
    }

}
