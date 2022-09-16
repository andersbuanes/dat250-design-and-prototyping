import models.IoTVotingDevice;
import models.Poll;
import models.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Main {

    private static final String PERSISTENCE_UNIT_NAME = "pollApp";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

//        addSampleData(em);
//        readAndPrintData(em);
    }

    private static void addSampleData(EntityManager em) {
        // User
        Account user1 = new Account();
        user1.setId(UUID.randomUUID().toString());
        user1.setName("Lars");
        user1.setAdmin(false);

        // Poll
        Poll poll1 = new Poll(1111, "Pizza eller taco?", "Pizza", "Taco", false, LocalDateTime.now(), LocalDateTime.now().plusDays(7), false, user1);
        user1.getPolls().add(poll1);

        // IoT Device
        IoTVotingDevice iot1 = new IoTVotingDevice();
        iot1.setName("device1");
        iot1.setPincode(1234);

        em.getTransaction().begin();
        em.persist(iot1);
        em.persist(user1);
        em.persist(poll1);
        em.getTransaction().commit();
    }

    private static void readAndPrintData(EntityManager em) {
        List<Account> accounts = em.createQuery("select a from Account a", Account.class).getResultList();
        for (Account a : accounts) {
            for (Poll p : a.getPolls()) {
                System.out.println(p.getQuestion());
            }
        }


    }

}
