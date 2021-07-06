package com.example.springintilizr.controller;

import io.spring.initializr.metadata.DependencyGroup;
import io.spring.initializr.web.support.DefaultInitializrMetadataProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class RegistrationController {

  private final DefaultInitializrMetadataProvider defaultInitializrMetadataProvider;

  @GetMapping("custom/dependencies")
  public List<DependencyGroup> getCustomDependencies() {
    return defaultInitializrMetadataProvider.get().getDependencies().getContent();
  }
}
