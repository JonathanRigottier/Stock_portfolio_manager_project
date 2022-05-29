package persistence;

import model.Broker;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class RepositoryBroker {

    private EntityManager entityManager;

    public RepositoryBroker() {
        entityManager = DBUtil.getEntityManager();
    }

    public void saveBroker (Broker broker) {  //dml
        try {
            LocalDate dateOfRegister = LocalDate.now();
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(broker);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }
    }

}
