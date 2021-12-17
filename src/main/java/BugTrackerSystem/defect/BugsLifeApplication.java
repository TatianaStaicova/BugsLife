package BugslifeTeam.BugsLife;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BugsLifeApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(BugsLifeApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BugsLifeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RestTemplate restTemplate = new RestTemplate();

	}
}
