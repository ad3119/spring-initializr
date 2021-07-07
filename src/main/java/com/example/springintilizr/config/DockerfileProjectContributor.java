package com.example.springintilizr.config;

import com.example.springintilizr.model.Dockerfile;
import io.spring.initializr.generator.project.contributor.ProjectContributor;
import lombok.Cleanup;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class DockerfileProjectContributor implements ProjectContributor {

  private final Dockerfile dockerfile;

  public DockerfileProjectContributor(Dockerfile dockerfile) {
    this.dockerfile = dockerfile;
  }

  @Override
  public void contribute(Path projectRoot) throws IOException {
    Path output = projectRoot.resolve("Dockerfile");
    @Cleanup PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(output));
    this.dockerfile.write(printWriter);
  }
}
