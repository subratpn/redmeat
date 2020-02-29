package store.redmeat.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "suppliers")
public class ProductSupplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;


}
