package persistence;

import model.Stock;
import model.User;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryStock {

    private EntityManager entityManager;

    public RepositoryStock() {
        entityManager = DBUtil.getEntityManager();
    }

    public void saveStock (Stock stock) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(stock);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }
    }

    public void deleteStock (Stock stock) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(entityManager.merge(stock));
            this.entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
    }

    public List<Stock> listAllStocks(){
        return this.entityManager
                .createQuery("FROM Stock", Stock.class)
                .getResultList();
    }

    public Stock searchById(int stockId) {
        return entityManager.find(Stock.class, stockId);
    }

    public void updateStockPriceById (int stockId, float newPrice) {
        try {
            entityManager.clear();
            this.entityManager.getTransaction().begin();
            String sql = "UPDATE Stock SET current_price = :nPrice WHERE stock_id = :id ";
            entityManager.createQuery(sql)
                    .setParameter("id", stockId)
                    .setParameter("nPrice", newPrice)
                    .executeUpdate();
            this.entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
    }

}
