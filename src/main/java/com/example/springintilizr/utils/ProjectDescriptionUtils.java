package com.example.springintilizr.utils;

import io.spring.initializr.metadata.InitializrMetadata;
import io.spring.initializr.web.support.DefaultInitializrMetadataProvider;

import java.util.HashMap;
import java.util.Map;

public class ProjectDescriptionUtils {

  public static Map<String, Object> getProjectCommonProperties(
      DefaultInitializrMetadataProvider defaultInitializrMetadataProvider) {
    InitializrMetadata initializrMetadata = defaultInitializrMetadataProvider.get();
    Map<String, Object> model = new HashMap<>();
    model.put("artifactId", initializrMetadata.getArtifactId().getContent());
    model.put("version", initializrMetadata.getVersion().getContent());
    model.put("artifactPath", "build/libs");
    return model;
  }
}
