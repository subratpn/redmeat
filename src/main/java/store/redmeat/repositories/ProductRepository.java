package store.redmeat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.redmeat.models.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Override
    <S extends Product> S save(S s);

    @Override
    List<Product> findAll();


    List<Product> findAllByCityId(Integer id);
}
