package store.redmeat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.redmeat.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    Role findByRole(String s);

}
