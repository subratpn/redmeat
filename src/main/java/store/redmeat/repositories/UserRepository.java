package store.redmeat.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import store.redmeat.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    User findByMobile(String s);

    @Override
    <S extends User> S save(S s);

}
