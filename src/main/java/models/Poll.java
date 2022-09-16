package models;

import lombok.Data;
import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@UuidGenerator(name = "pollIdGenerator")
@Data
public class Poll {
    @Id
    @GeneratedValue(generator = "pollIdGenerator")
    private String id;

    private int pincode;
    private String question;
    private String answerA;
    private String answerB;
    private boolean isPrivate;
    private LocalDateTime stateDate;
    private LocalDateTime endDate;
    private boolean isClosed;

    public Poll() {}

    public Poll(int pincode,
                String question,
                String answerA,
                String answerB,
                boolean isPrivate,
                LocalDateTime stateDate,
                LocalDateTime endDate,
                boolean isClosed,
                Account account) {
        this.pincode = pincode;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.isPrivate = isPrivate;
        this.stateDate = stateDate;
        this.endDate = endDate;
        this.isClosed = isClosed;
        this.account = account;
    }

    @ManyToOne
    @JoinColumn(name = "accountId", referencedColumnName = "id")
    public Account account;

    @OneToMany(mappedBy = "poll")
    public Set<Vote> votes = new HashSet<>();

    @OneToMany(mappedBy = "poll")
    public Set<IoTVotes> iotVotes = new HashSet<>();

}
