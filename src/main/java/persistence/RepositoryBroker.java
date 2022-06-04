package persistence;

import model.Broker;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryBroker {

    private EntityManager entityManager;

    public RepositoryBroker() {
        entityManager = DBUtil.getEntityManager();
    }

    public void saveBroker (Broker broker) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(broker);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }
    }

    public void deleteBroker (Broker broker) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(entityManager.merge(broker));
            this.entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
    }

    public List<Broker> listAllBrokers(){
        return this.entityManager
                .createQuery("FROM Broker", Broker.class)
                .getResultList();
    }

    public void updateBroker (Broker broker) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(broker);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }

    }

    public List<Broker> listOfUsersByBroker() {
        String sql = "SELECT b.name, COUNT(u.broker) " +
                "FROM User u INNER JOIN Broker b ON u.broker = b.broker_id " +
                "GROUP BY b.name ";

        return this.entityManager.createQuery(sql, Broker.class)
                .getResultList();

    }
}
