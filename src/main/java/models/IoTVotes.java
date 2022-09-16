package models;

import lombok.Data;
import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@UuidGenerator(name = "iotVotesIdGenerator")
@Data
public class IoTVotes {

    @Id
    @GeneratedValue(generator = "iotVotesIdGenerator")
    public String id;

    @Id
    public int pincode;

    public int answerA;
    public int answerB;

    @ManyToOne
    public IoTVotingDevice votingDevice;

    @ManyToOne
    public Poll poll;

}
