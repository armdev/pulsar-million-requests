package io.project.app.pulsar.main;


import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author armdev
 */
@Configuration
class SwaggerConfig {
 
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("magnetar")
                .pathsToMatch("/api/**")
                .build();
    }


}
