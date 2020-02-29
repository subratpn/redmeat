package store.redmeat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.redmeat.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByMobile(String s);

    @Override
    <S extends User> S save(S s);


}
