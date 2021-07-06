package com.example.springintilizr.config;

import io.spring.initializr.metadata.InitializrMetadata;
import io.spring.initializr.metadata.InitializrMetadataBuilder;
import io.spring.initializr.metadata.InitializrProperties;
import io.spring.initializr.web.support.DefaultInitializrMetadataProvider;
import io.spring.initializr.web.support.InitializrMetadataUpdateStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties(CustomIntializrProperties.class)
public class RegistrationConfiguration {

  @Bean
  public DefaultInitializrMetadataProvider customInitializrMetadataProvider(
      final InitializrProperties initializrProperties,
      final CustomIntializrProperties customProperties,
      InitializrMetadataUpdateStrategy initializrMetadataUpdateStrategy) {
    log.info("Custom Properties {}", customProperties);
    InitializrMetadata meta =
        InitializrMetadataBuilder.fromInitializrProperties(initializrProperties)
            .withInitializrProperties(customProperties.getInitializr(), true)
            .build();
    return new DefaultInitializrMetadataProvider(meta, initializrMetadataUpdateStrategy);
  }
}
