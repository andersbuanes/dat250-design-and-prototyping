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
    private String id;

    //Can be implemented further later
    enum Answer {
        Yes, NO
    }

    private Answer answer;

    @ManyToOne
    private Poll poll;

    @ManyToOne
    private VoteUser user;

}
