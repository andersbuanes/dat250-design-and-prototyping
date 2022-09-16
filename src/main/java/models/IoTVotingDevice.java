package models;

import lombok.Data;
import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@UuidGenerator(name = "iotDeviceIdGenerator")
@Data
public class IoTVotingDevice {
    @Id
    @GeneratedValue(generator = "iotDeviceIdGenerator")
    private String id;

    private int pincode;

    private String name;

    @OneToMany(mappedBy = "votingDevice")
    private Set<IoTVotes> votes = new HashSet<>();

}
