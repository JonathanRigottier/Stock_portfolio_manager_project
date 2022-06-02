package persistence;

import java.util.List;
import javax.persistence.EntityManager;
import model.Customer;
import util.DBUtil;

public class RepositoryCustomer {

    private EntityManager em;

    public RepositoryCustomer() {
        em = DBUtil.getEntityManager();
    }

    @SuppressWarnings("unchecked")
    public List<Customer> listAllCustomers() {
        return em.createQuery("Select f from Customer as f order by f.firstName asc")
                .getResultList();
    }

    public void saveCustomer(Customer customer) {
        try {
            this.em.getTransaction().begin();
            this.em.persist(customer);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    public void deleteCustomer (Customer customer) {
        try {
            this.em.getTransaction().begin();
            this.em.remove(em.merge(customer));
            this.em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

}
