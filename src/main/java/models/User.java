package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    private UUID id;

    private String name;
    private boolean isAdmin;

    @OneToMany(mappedBy = "user")
    private Vote vote;

    @OneToMany(mappedBy = "user")
    public Poll poll;






}
