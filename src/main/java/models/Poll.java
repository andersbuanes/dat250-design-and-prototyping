package models;

import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@UuidGenerator(name = "pollIdGenerator")
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

    @OneToMany(mappedBy = "poll", cascade = CascadeType.PERSIST)
    public Set<Vote> votes = new HashSet<>();

    @OneToMany(mappedBy = "poll", cascade = CascadeType.PERSIST)
    public Set<IoTVotes> iotVotes = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public LocalDateTime getStateDate() {
        return stateDate;
    }

    public void setStateDate(LocalDateTime stateDate) {
        this.stateDate = stateDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }

    public Set<IoTVotes> getIotVotes() {
        return iotVotes;
    }

    public void setIotVotes(Set<IoTVotes> iotVotes) {
        this.iotVotes = iotVotes;
    }
}
