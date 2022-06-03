package persistence;

import model.Broker;
import model.User;
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
}
