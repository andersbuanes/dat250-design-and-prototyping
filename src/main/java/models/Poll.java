package models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Poll {
    @Id
    @GeneratedValue(generator = "uuid")
    public UUID id;

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
    public User user;

    @OneToMany(mappedBy = "poll")
    public Set<Vote> votes;

    @OneToMany(mappedBy = "poll")
    public Set<IoTVotes> iotVotes;

}
