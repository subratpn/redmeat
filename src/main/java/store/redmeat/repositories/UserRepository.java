package store.redmeat.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import store.redmeat.models.User;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByMobile(String s);

    @Override
    <S extends User> S save(S s);

    @Query("{ 'deliveryAddress.city' : ?0 }")
    List<User> findAllByCity(String city);
}
