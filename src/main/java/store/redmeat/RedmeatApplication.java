package store.redmeat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import store.redmeat.models.Role;
import store.redmeat.repositories.RoleRepository;

@SpringBootApplication
public class RedmeatApplication implements CommandLineRunner {

	@Autowired
	RoleRepository roleRepository;

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
