package models;

import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.*;

@Entity
@UuidGenerator(name = "voteIdGenerator")
public class Vote {
    @Id
    @GeneratedValue(generator = "voteIdGenerator")
    private String id;

    public enum Answer {
        ANSWER_A, ANSWER_B
    }

    private Answer answer;

    @ManyToOne
    private Poll poll;

    @ManyToOne
    private Account account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
