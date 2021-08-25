/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.pulsar.main;

import io.github.majusko.pulsar.producer.ProducerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author armena
 */
@Configuration
public class PulsarProducer {

    @Bean
    public ProducerFactory producerFactory() {
        return new ProducerFactory()                
                .addProducer("pulse", String.class);
    }
    
    @Bean
    public ProducerFactory producerEventFactory() {
        return new ProducerFactory()                
                .addProducer("redline", String.class);
    }
}
