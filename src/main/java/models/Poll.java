package models;

import lombok.Data;
import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@UuidGenerator(name = "pollIdGenerator")
@Data
public class Poll {
    @Id
    @GeneratedValue(generator = "pollIdGenerator")
    public String id;

    public int pincode;
    public String question;
    public String answerA;
    public String answerB;
    public boolean isPrivate;
    public LocalDateTime stateDate;
    public LocalDateTime endDate;
    public boolean isClosed;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    public VoteUser user;

    @OneToMany(mappedBy = "poll")
    public Set<Vote> votes;

//    @OneToMany(mappedBy = "poll")
//    public Set<IoTVotes> iotVotes;

}
