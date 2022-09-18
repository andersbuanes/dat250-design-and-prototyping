import dao.AccountDAO;
import dao.IoTVotingDeviceDAO;
import dao.PollDAO;
import models.*;

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
        AccountDAO accountDAO = new AccountDAO(em);
        Account account1 = new Account();
        account1.setId(UUID.randomUUID().toString());
        account1.setName("Lars");
        account1.setAdmin(false);
        accountDAO.createAccount(account1);

        // Poll
        Poll poll1 = new Poll(1111, "Pizza eller taco?", "Pizza", "Taco", false, LocalDateTime.now(), LocalDateTime.now().plusDays(7), false, account1);
        PollDAO pollDAO = new PollDAO(em);
        pollDAO.createPoll(poll1);

        // Account vote
        Vote vote1 = new Vote();
        vote1.setAccount(account1);
        vote1.setPoll(poll1);
        vote1.setAnswer(Vote.Answer.ANSWER_A);

        poll1.getVotes().add(vote1);
        pollDAO.updatePoll(poll1);

        // IoT Device
        IoTVotingDevice iot1 = new IoTVotingDevice();
        iot1.setName("device1");
        iot1.setPincode(1234);
        IoTVotingDeviceDAO ioTVotingDeviceDAO = new IoTVotingDeviceDAO(em);
        ioTVotingDeviceDAO.createIoTVotingDevice(iot1);

        // IoT votes
        IoTVotes iotVotes1 = new IoTVotes();
        iotVotes1.setAnswerA(10);
        iotVotes1.setAnswerB(8);
        iotVotes1.setVotingDevice(iot1);
        iotVotes1.setPoll(poll1);
        iot1.getVotes().add(iotVotes1);

        IoTVotingDeviceDAO ioTVotingDeviceDAO1 = new IoTVotingDeviceDAO(em);
        ioTVotingDeviceDAO1.updateIoTVotingDevice(iot1);

    }

    private static void readAndPrintData(EntityManager em) {
        PollDAO pollDAO = new PollDAO(em);
        List<Poll> polls = pollDAO.getAllPolls();

        for (Poll p : polls) {
            long answerCountA = p.getVotes().stream()
                    .filter(v -> v.getAnswer() == Vote.Answer.ANSWER_A).count();
            long answerCountB = p.getVotes().stream()
                    .filter(v -> v.getAnswer() == Vote.Answer.ANSWER_B).count();
            for (IoTVotes iotVote : p.getIotVotes()) {
                answerCountA += iotVote.getAnswerA();
                answerCountB += iotVote.getAnswerB();
            }

            System.out.println("Poll question: " + p.getQuestion());
            System.out.println("Poll answer A (" + p.getAnswerA() + "): " + answerCountA);
            System.out.println("Poll answer B (" + p.getAnswerB() + "): " + answerCountB);
        }
    }

}
