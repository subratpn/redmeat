package store.redmeat.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String title;
    private String description;
    private String price;
    private String quantity;
    @DBRef
    private Set<Image> images;
    @DBRef
    private ProductSupplier productSupplier;



}
