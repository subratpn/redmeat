package store.redmeat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.redmeat.models.Product;
import store.redmeat.repositories.ProductRepository;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("products")
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }


}
