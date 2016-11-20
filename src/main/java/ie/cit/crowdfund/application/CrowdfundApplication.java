package ie.cit.crowdfund.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrowdfundApplication {
    //TODO LocaleResolver to be set in config class.
	public static void main(String[] args) {
		SpringApplication.run(CrowdfundApplication.class, args);
	}
}
