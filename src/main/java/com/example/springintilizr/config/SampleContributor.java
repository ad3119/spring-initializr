package com.example.springintilizr.config;

import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.generator.project.contributor.ProjectContributor;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
      Files.createDirectory(projectRoot.resolve(file.getAbsolutePath() + "/" + directory));

      if (directory.equals("controller")) {
        Path filePath =
            Files.createFile(
                projectRoot.resolve(
                    file.getAbsolutePath() + "/" + directory + "/TestController.java"));

        @Cleanup PrintWriter writer = new PrintWriter(Files.newBufferedWriter(filePath));

        writer.println("package com.jpmorgan.gti.sf.osb.controller; ");
        writer.println(
            "import org.springframework.web.bind.annotation.GetMapping;\n"
                + "import org.springframework.web.bind.annotation.RequestMapping;\n "
                + "import org.springframework.web.bind.annotation.RestController;\n ");
        writer.println("@RestController");
        writer.println("@RequestMapping(\"api/v1\")");
        writer.println("public class TestController {");
        writer.println("@GetMapping(\"test\")");
        writer.println("public String test() {");
        writer.println("return \"Hello\";");
        writer.println("}}");
      }
    }
  }
}
