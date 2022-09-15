package models;

import lombok.Data;
import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@UuidGenerator(name = "pollIdGenerator")
@Data
public class IoTVotingDevice {
    @Id
    @GeneratedValue(generator = "uuid")
    public String id;

    public int pincode;

    public String name;

    @OneToMany(mappedBy = "votingDevice")
    public Set<IoTVotes> votes;

}
