package jade;

import jade.domain.Community;
import jade.domain.Customer;
import jade.domain.Member;
import jade.domain.Order;
import jade.repository.CustomerRepository;
import jade.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringJpaDemoApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringJpaDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}
}
