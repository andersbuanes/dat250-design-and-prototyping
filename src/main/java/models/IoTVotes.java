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
    private String id;

    @Id
    private int pincode;

    private int answerA;
    private int answerB;

    @ManyToOne
    private IoTVotingDevice votingDevice;

    @ManyToOne
    private Poll poll;

}
