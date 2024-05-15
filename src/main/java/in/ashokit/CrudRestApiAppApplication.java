package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Customer;
import in.ashokit.repo.CustomerRepo;

@SpringBootApplication
public class CrudRestApiAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(CrudRestApiAppApplication.class, args);
	}

}
