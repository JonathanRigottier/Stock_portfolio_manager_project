package persistence;

import model.Broker;
import model.Stock_ideas;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryStock_ideas {

    private EntityManager entityManager;

    public RepositoryStock_ideas() {
        entityManager = DBUtil.getEntityManager();
    }

    public void saveStockIdeas (Stock_ideas stock_ideas) {  //dml
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(stock_ideas);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }
    }

    public void deleteStockIdeas (Stock_ideas stock_ideas) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(entityManager.merge(stock_ideas));
            this.entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
    }

    public List<Stock_ideas> listAllStockIdeas(){
        return this.entityManager
                .createQuery("FROM Stock_ideas", Stock_ideas.class)
                .getResultList();
    }

    public void updateStockIdeas (Stock_ideas stock_ideas) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(stock_ideas);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }

    }
}
