package com.example.springintilizr.config;

import com.example.springintilizr.utils.RestControllerGeneratorUtil;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.generator.project.contributor.ProjectContributor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@ProjectGenerationConfiguration
@Slf4j
public class SampleContributor implements ProjectContributor {

  /**
   * Creates directories in root directory. Creating the standard directories used in Spring project
   * and a Test Controller
   *
   * <p>TODO: Consider picking the package path dynamically
   *
   * @param projectRoot
   * @throws IOException
   */
  @Override
  public void contribute(Path projectRoot) throws IOException {
    log.info("Inside Directory Creation");
    final String[] directories =
        new String[] {"controller", "services", "model", "repository", "config"};

    File file = new File(projectRoot.resolve("src/main/java/com/jpmorgan/gti/sf/osb").toUri());
    file.mkdirs();

    for (final String directory : directories) {
      Path directoryPath =
          Files.createDirectory(projectRoot.resolve(file.getAbsolutePath() + "/" + directory));

      if (directory.equals("controller")) {
        RestControllerGeneratorUtil.generateRestController()
            .writeTo(projectRoot.resolve("src/main/java"));
      }
    }
  }
}
