package org.tqa.utils.filerandomdata;

import com.github.javafaker.Faker;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FileContentGenerator {

  private Faker faker = new Faker(new Locale("ru"));
  private LocalDate date = LocalDate.now();
  private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
  String today = date.format(dateTimeFormatter);
  private Logger log = LoggerFactory.getLogger(this.getClass());

  private static File root = new File("./data");
//add_file_2019-12-23.csv
private String fileName = "add_tqafilelist_"+today+".csv";
Integer lines = 100;


  public void generate() throws IOException {
    Path fullPath = new File(root, fileName).toPath();
    Files.createDirectories(fullPath.getParent());

    try (BufferedWriter bw = Files.newBufferedWriter(fullPath)) {
      for (int i = 0; i < lines; ++i) {
        String msisdn = faker.numerify("7##########");
        bw.write(msisdn+String.format("%n" ));
        System.out.println(today);
        System.out.println("DONE");
      }
    }
  }
}