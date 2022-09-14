package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class VoteUser {
    @Id
    public String id;

    public String name;
    public boolean isAdmin;

    @OneToMany(mappedBy = "user")
    public Set<Vote> votes;

    @OneToMany(mappedBy = "user")
    public Set<Poll> polls;

}
