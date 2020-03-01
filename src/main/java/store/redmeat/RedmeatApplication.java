package store.redmeat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import store.redmeat.models.Role;
import store.redmeat.repositories.ProductRepository;
import store.redmeat.repositories.RoleRepository;
import store.redmeat.repositories.UserRepository;

import javax.persistence.EntityManager;


@EnableSwagger2
@SpringBootApplication
public class RedmeatApplication implements CommandLineRunner {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(RedmeatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role adminRole = roleRepository.findByRole("ADMIN");
		if (adminRole == null) {
			Role newAdminRole = new Role();
			newAdminRole.setRole("ADMIN");
			roleRepository.save(newAdminRole);
		}

		Role customerRole = roleRepository.findByRole("CUSTOMER");
		if (customerRole == null) {
			Role newCustomerRole = new Role();
			newCustomerRole.setRole("CUSTOMER");
			roleRepository.save(newCustomerRole);
		}


	}
}
