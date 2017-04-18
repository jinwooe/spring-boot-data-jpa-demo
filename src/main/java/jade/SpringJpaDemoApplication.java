package jade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringJpaDemoApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringJpaDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			Customer jackBauer = new Customer("Jack", "Bauer");
			jackBauer.setOrders(new ArrayList<Order>(){{
				add(new Order(jackBauer, "Sandwich"));
			}});
			repository.save(jackBauer);
		};
	}
}
