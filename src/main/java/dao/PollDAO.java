package dao;

import models.Poll;

import javax.persistence.EntityManager;
import java.util.List;

public class PollDAO {

    private EntityManager em;

    public PollDAO(EntityManager em) {
        this.em = em;
    }

    public List<Poll> getAllPolls() {
        return em.createQuery("select p from Poll p", Poll.class).getResultList();
    }

    public Poll getPollById(String id) {
        List<Poll> pollList = em
                .createQuery("select p from Poll p where p.id = :id", Poll.class)
                .setParameter("id", id)
                .getResultList();

        if (!pollList.isEmpty()) {
            return pollList.get(0);
        }
        return null;
    }

    public void createPoll(Poll poll) {
        em.getTransaction().begin();
        em.persist(poll);
        em.getTransaction().commit();
    }

    public void updatePoll(Poll poll) {
        em.getTransaction().begin();
        em.persist(poll);
        em.getTransaction().commit();
    }

    public void deletePoll(Poll poll) {
        em.getTransaction().begin();
        em.remove(poll);
        em.getTransaction().commit();
    }

}
