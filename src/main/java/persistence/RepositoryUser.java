package persistence;

import model.Broker;
import model.Stock;
import model.User;
import model.userBrokerPortfolioStock_ideas;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryUser {

    private EntityManager entityManager;

    public RepositoryUser() {
        entityManager = DBUtil.getEntityManager();
    }

    public void saveUser (User user) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(user);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }
    }

    public void deleteUser (User user) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(entityManager.merge(user));
            this.entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
    }

    public List<User> listAllUsers(){
        return this.entityManager
                .createQuery("FROM User", User.class)
                .getResultList();
    }

    public void updateUser (User user) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(user);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
    }

    public long countTotalOfUser () {
        return (Long) entityManager.createQuery("SELECT count(*) from User")
                .getSingleResult();
    }

    public List<userBrokerPortfolioStock_ideas> listUsernameWithAmountStockWithBrokerWithStockIdeas() {
        String sql = "SELECT new model.userBrokerPortfolioStock_ideas (u.username, u.portfolio.amount_of_stock_purchased, u.broker.name,  u.stock_ideas.name) " +
                "FROM User u";

        return this.entityManager.createQuery(sql, userBrokerPortfolioStock_ideas.class)
                .getResultList();
    }

    public List<User> listOfUserRegisteredByBrokerChoice (String brokerName) {
        String sql = "FROM User u WHERE u.broker.name = : brokerName ORDER BY u.username";
        return this.entityManager.createQuery(sql, User.class)
                .setParameter("brokerName", brokerName)
                .getResultList();
    }

}
