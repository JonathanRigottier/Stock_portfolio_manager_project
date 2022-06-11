package persistence;

import model.Broker;
import model.UsersByBroker;
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

    public List listOfUsersByBroker() {
        String sql = "SELECT new model.UsersByBroker (u.broker.name, COUNT(u.user_id)) " +
                "FROM User u RIGHT OUTER JOIN u.broker b " +
                "GROUP BY b.name ";

        //entityManager.createNativeQuery("SELECT b.name, COUNT(u.broker_id)" +
        //        "FROM User u RIGHT OUTER JOIN Broker b ON u.broker_id = b.broker_id GROUP BY b.name ");

        return this.entityManager.createQuery(sql, UsersByBroker.class)
               .getResultList();

    }
}
