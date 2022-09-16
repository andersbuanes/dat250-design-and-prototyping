package models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Account {
    @Id
    private String id;

    private String name;
    private boolean isAdmin;

    @OneToMany(mappedBy = "account")
    private Set<Vote> votes = new HashSet<>();

    @OneToMany(mappedBy = "account")
    private Set<Poll> polls = new HashSet<>();

}
