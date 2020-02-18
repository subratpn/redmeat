package store.redmeat.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import store.redmeat.models.Role;

import java.util.Set;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String s);

    Set<Role> findAllByRole(Set<String> roles);

}
