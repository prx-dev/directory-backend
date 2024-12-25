package com.prx.directory.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.netflix.discovery.shared.Applications;
import com.netflix.discovery.shared.transport.jersey.TransportClientFactories;
import com.netflix.discovery.shared.transport.jersey3.Jersey3TransportClientFactories;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.cloud.netflix.eureka.http.RestTemplateDiscoveryClientOptionalArgs;
import org.springframework.cloud.netflix.eureka.http.RestTemplateTransportClientFactories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Discovery Client optional arguments.
 * This class provides bean definitions for various components used in the Discovery Client.
 */
@Configuration
public class DiscoveryClientOptionalArgConfiguration {

    /**
     * Default constructor.
     * Creates a new instance of DiscoveryClientOptionalArgConfiguration.
     */
    public DiscoveryClientOptionalArgConfiguration() {
        // Default constructor
    }

    /**
     * Creates a Jersey3TransportClientFactories bean if no other TransportClientFactories bean is present.
     *
     * @return a Jersey3TransportClientFactories instance
     */
    @Bean
    @ConditionalOnMissingBean(TransportClientFactories.class)
    public Jersey3TransportClientFactories jersey3TransportClientFactories() {
        return Jersey3TransportClientFactories.getInstance();
    }

    /**
     * Creates an ObjectMapper bean with a custom deserializer for Applications.
     *
     * @return an ObjectMapper instance
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Applications.class, new ApplicationsDeserializer());
        objectMapper.registerModule(module);
        return objectMapper;
    }

    /**
     * Creates a RestTemplateTransportClientFactories bean if RestTemplate and JerseyClient classes are present
     * and no other TransportClientFactories bean is present in the current context.
     *
     * @param optionalArgs the optional arguments for the RestTemplateDiscoveryClient
     * @return a RestTemplateTransportClientFactories instance
     */
    @Bean
    @ConditionalOnClass(name = {"org.springframework.web.client.RestTemplate", "org.glassfish.jersey.client.JerseyClient"})
    @ConditionalOnMissingBean(value = {TransportClientFactories.class}, search = SearchStrategy.CURRENT)
    public RestTemplateTransportClientFactories restTemplateTransportClientFactories(RestTemplateDiscoveryClientOptionalArgs optionalArgs) {
        return new RestTemplateTransportClientFactories(optionalArgs);
    }
}
