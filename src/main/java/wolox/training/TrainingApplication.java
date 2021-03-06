
package wolox.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.slf4j.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class TrainingApplication {
	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}
}