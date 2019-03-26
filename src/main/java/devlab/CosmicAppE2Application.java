package devlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:config.properties")
@SpringBootApplication
public class CosmicAppE2Application {

  public static void main(String[] args) {
    SpringApplication.run(CosmicAppE2Application.class, args);
  }

}
