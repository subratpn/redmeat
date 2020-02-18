package store.redmeat.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "products")
@Data
public class Product {

    @Id
    private String id;
    private String title;
    private String description;
    private String price;
    private String quantity;
    private Set<Image> images;
    private Set<ProductSupplier> productSuppliers;


}
