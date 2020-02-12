package org.tqa.utils.filerandomdata;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileRandomDataApplication {

  public FileRandomDataApplication (FileContentGenerator fileContentGenerator)
    throws IOException { fileContentGenerator.generate();

}
  public static void main(String[] args) {
    SpringApplication.run(FileRandomDataApplication.class, args);
  }

}
