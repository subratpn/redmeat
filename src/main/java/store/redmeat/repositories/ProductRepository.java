package store.redmeat.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import store.redmeat.models.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {

    @Override
    <S extends Product> S save(S s);

    @Override
    List<Product> findAll();


}
