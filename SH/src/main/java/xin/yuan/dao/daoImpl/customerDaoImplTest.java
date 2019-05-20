package xin.yuan.dao.daoImpl;

import org.junit.jupiter.api.Test;
import xin.yuan.domain.Customer;
import xin.yuan.service.CustomerService;
import xin.yuan.service.impl.CustomerServiceImpl;
import xin.yuan.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;


public class customerDaoImplTest {

    @Test
    public void findAllCustomer() {
        CustomerService service = new CustomerServiceImpl();
         List<Customer> list = service.findAllCustomer();
         for (Customer c : list){
             System.out.println(c);
         }
    }

    @Test
    public void insertCustomer(){

        Customer c = new Customer();
        c.setCustName("12");
        c.setCustIndustry("dd");
        c.setCustPhone("dd");
        c.setCustAddress("ddsef");
        c.setCustSource("ssf");
        c.setCustLevel("dfdf");
        EntityManager em = JPAUtil.creatEntityManager();//拿到实体管理器也就是本土的session对象
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(c);//保存，相当于save（）；

        tx.commit();
    }
}