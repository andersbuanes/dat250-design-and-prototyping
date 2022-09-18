package dao;

import models.IoTVotingDevice;

import javax.persistence.EntityManager;
import java.util.List;

public class IoTVotingDeviceDAO {

    private EntityManager em;

    public IoTVotingDeviceDAO(EntityManager em) {
        this.em = em;
    }

    public IoTVotingDevice getVotingDeviceById(String id) {
        List<IoTVotingDevice> deviceList = em
                .createQuery("select d from IoTVotingDevice d where d.id = :id", IoTVotingDevice.class)
                .setParameter("id", id)
                .getResultList();

        if (!deviceList.isEmpty()) {
            return deviceList.get(0);
        }
        return null;
    }

    public void createIoTVotingDevice(IoTVotingDevice device) {
        em.getTransaction().begin();
        em.persist(device);
        em.getTransaction().commit();
    }

    public void updateIoTVotingDevice(IoTVotingDevice device) {
        em.getTransaction().begin();
        em.persist(device);
        em.getTransaction().commit();
    }

    public void deleteIoTVotingDevice(IoTVotingDevice device) {
        em.getTransaction().begin();
        em.remove(device);
        em.getTransaction().commit();
    }

}
