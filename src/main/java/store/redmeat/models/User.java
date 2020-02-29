package store.redmeat.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "users")
@Data
public class User {

    @Id
    private String mobile;
    private String password;
    private String email;
    private String fullName;
    private boolean enabled;
    private Set<Role> roles;
    private Image profilePicture;
    private Address deliveryAddress;


}
