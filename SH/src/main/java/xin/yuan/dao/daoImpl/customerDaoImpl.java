package xin.yuan.dao.daoImpl;


import xin.yuan.dao.CustomerDao;
import xin.yuan.domain.Customer;
import xin.yuan.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * @authorknightx
 * @create2019/1/8
 * @since 1.0.0
 */
public class customerDaoImpl implements CustomerDao {

    EntityManager em = JPAUtil.creatEntityManager();


    @Override
    public List<Customer> findAllCustomer() {

        Query query = em.createQuery("select c from Customer c");
         List<Customer> customerList = query.getResultList();


        return customerList;
    }

    @Override

    //保存操作在业务层配置事物会无法提交到数据库，所以没办法只能在这里配置了
    public void insertCustomer(Customer customer) {


        EntityManager em = null;;
        EntityTransaction tx = null;

        try {
            em=JPAUtil.creatEntityManager();
            tx = em.getTransaction();

            tx.begin();
            em.persist(customer);
            tx.commit();

        }catch (Exception e){
            tx.rollback();
            throw new RuntimeException(e);
        }

    }


}
