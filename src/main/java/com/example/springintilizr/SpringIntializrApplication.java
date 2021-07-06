package com.example.springintilizr;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.spring.initializr.web.support.SaganInitializrMetadataUpdateStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class SpringIntializrApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringIntializrApplication.class, args);
  }

  // This bean opt-in for fetching available Spring Boot versions from Sagan (spring.io)
  @Bean
  SaganInitializrMetadataUpdateStrategy saganInitializrMetadataUpdateStrategy(
      RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
    final SaganInitializrMetadataUpdateStrategy saganInitializrMetadataUpdateStrategy =
        new SaganInitializrMetadataUpdateStrategy(restTemplateBuilder.build(), objectMapper);
    log.info("Sagan {}", saganInitializrMetadataUpdateStrategy);
    return saganInitializrMetadataUpdateStrategy;
  }
}
