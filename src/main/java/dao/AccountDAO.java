package dao;

import models.Account;

import javax.persistence.EntityManager;
import java.util.List;

public class AccountDAO {

    private EntityManager em;

    public AccountDAO(EntityManager em) {
        this.em = em;
    }

    public Account getAccountById(String id) {
        List<Account> accountList = em
                .createQuery("select a from Account a where a.id = :id", Account.class)
                .setParameter("id", id)
                .getResultList();

        if (!accountList.isEmpty()) {
            return accountList.get(0);
        }
        return null;
    }

    public void createAccount(Account account) {
        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
    }

    public void updateAccount(Account account) {
        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
    }

    public void deleteAccount(Account account) {
        em.getTransaction().begin();
        em.remove(account);
        em.getTransaction().commit();
    }

}
