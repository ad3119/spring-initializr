package com.example.springintilizr.config;

import com.example.springintilizr.model.Dockerfile;
import com.example.springintilizr.utils.ProjectDescriptionUtils;
import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.web.support.DefaultInitializrMetadataProvider;
import org.springframework.context.annotation.Bean;

@ProjectGenerationConfiguration
public class DockerProjectGenerationConfiguration {

  @Bean
  public Dockerfile dockerfile(
      MustacheTemplateRenderer templateRenderer,
      DefaultInitializrMetadataProvider defaultInitializrMetadataProvider) {
    return new Dockerfile(
        templateRenderer,
        "Dockerfile",
        ProjectDescriptionUtils.getProjectCommonProperties(defaultInitializrMetadataProvider));
  }

  @Bean
  public DockerfileProjectContributor dockerfileProjectContributor(Dockerfile dockerfile) {
    return new DockerfileProjectContributor(dockerfile);
  }
}
