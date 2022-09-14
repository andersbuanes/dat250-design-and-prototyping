package models;

import lombok.Data;
import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.*;

@Entity
@UuidGenerator(name = "voteIdGenerator")
@Data
public class Vote {
    @Id
    @GeneratedValue(generator = "voteIdGenerator")
    public String id;

    //Can be implemented further later
    enum Answer {
        Yes, NO
    }

    public Answer answer;

    @ManyToOne
    public Poll poll;

    @ManyToOne
    public VoteUser user;

}
