package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Vote {
    @Id
    @GeneratedValue(generator = "uuid")
    public UUID id;

    //Can be implemented further later
    enum Answer {
        Yes, NO
    }

    public Answer answer;


    @OneToMany
    public Set<Poll> polls;

    @OneToMany
    public Set<User> user;






}
