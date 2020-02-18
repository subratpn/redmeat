package store.redmeat.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "suppliers")
public class ProductSupplier {

    @Id
    private String id;
    private String title;
    @DBRef
    private Address address;


}
