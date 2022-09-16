package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class VoteUser {
    @Id
    private String id;

    private String name;
    private boolean isAdmin;

    @OneToMany(mappedBy = "user")
    private Set<Vote> votes;

    @OneToMany(mappedBy = "user")
    private Set<Poll> polls;

}
