package com.example.springintilizr.utils;

import io.spring.initializr.generator.buildsystem.gradle.GradleBuildSystem;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.metadata.InitializrMetadata;
import io.spring.initializr.web.support.DefaultInitializrMetadataProvider;

import java.util.HashMap;
import java.util.Map;

public class ProjectDescriptionUtils {

  public static String getBuildSystemArtifactPath(String projectDescription) {
    if (projectDescription.equals(GradleBuildSystem.ID)) {
      return "build/libs";
    } else {
      return "target";
    }
  }

  public static Map<String, Object> getProjectCommonProperties(
      ProjectDescription projectDescription) {
    Map<String, Object> model = new HashMap<>();
    model.put("artifactId", projectDescription.getArtifactId());
    model.put("version", projectDescription.getVersion());
    model.put(
        "artifactPath",
        ProjectDescriptionUtils.getBuildSystemArtifactPath(
            projectDescription.getBuildSystem().id()));
    return model;
  }

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
