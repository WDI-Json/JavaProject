package routeplannerpoc.windesheimdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class WindesheimDemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(WindesheimDemoApplication.class, args);
  }
}
