package com.example.springintilizr.config;

import io.spring.initializr.metadata.InitializrProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@ConfigurationProperties("custom")
public class CustomIntializrProperties {
  @NestedConfigurationProperty InitializrProperties initializr;
}
