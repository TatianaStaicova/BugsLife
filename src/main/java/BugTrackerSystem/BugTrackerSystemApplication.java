package BugTrackerSystem;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class BugTrackerSystemApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(BugTrackerSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BugTrackerSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RestTemplate restTemplate = new RestTemplate();

	}
}

