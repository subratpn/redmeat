package store.redmeat.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mobile;
    private String password;
    private String email;
    private String fullName;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
    @OneToOne
    private Cart cart;


}
