package store.redmeat.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String gross;
    private String unit;
    private String price;
    private String net;
    private Date created;
    private Date lastUpdated;
    @OneToOne
    private City city;
    private String stockUnits;
    private double discountInPercentage;
    private String cgst;
    private String sgst;
    @OneToOne
    private Image image;


}
