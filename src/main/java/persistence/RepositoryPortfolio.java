package persistence;

import model.Portfolio;
import model.Stock_ideas;
import util.DBUtil;

import javax.persistence.EntityManager;
import javax.sound.sampled.Port;
import java.util.List;

public class RepositoryPortfolio {

    private EntityManager entityManager;

    public RepositoryPortfolio() {
        entityManager = DBUtil.getEntityManager();
    }

    public void savePortfolio (Portfolio portfolio) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(portfolio);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }
    }

    public void deletePortfolio (Portfolio portfolio) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(entityManager.merge(portfolio));
            this.entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
    }

    public List<Portfolio> listAllPortfolios(){
        return this.entityManager
                .createQuery("FROM Portfolio", Portfolio.class)
                .getResultList();
    }

    public void updatePortfolio (Portfolio portfolio) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(portfolio);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }

    }
}
