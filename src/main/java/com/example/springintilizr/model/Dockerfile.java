package com.example.springintilizr.model;

import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.io.text.MustacheSection;

import java.util.Map;

public class Dockerfile extends MustacheSection {
  /**
   * Create a new instance.
   *
   * @param templateRenderer the {@link MustacheTemplateRenderer template renderer} to use
   * @param templateName the name of the template
   * @param model the initial model
   */
  public Dockerfile(
      MustacheTemplateRenderer templateRenderer, String templateName, Map<String, Object> model) {
    super(templateRenderer, templateName, model);
  }
}
