package xin.yuan.service.impl;

import xin.yuan.dao.CustomerDao;
import xin.yuan.dao.daoImpl.customerDaoImpl;
import xin.yuan.domain.Customer;
import xin.yuan.service.CustomerService;
import xin.yuan.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * @authorknightx
 * @create2019/1/8
 * @since 1.0.0
 *事物在业务层控制
 * 业务层实现类
 */
public class CustomerServiceImpl implements CustomerService {
/**
*@method:
*@return:
*@since: 1.0.0
*@Author:knightx
*@Date:2019/1/8
 * 查询所有客户
 *
*/
    private CustomerDao customerDao = new customerDaoImpl();

    @Override
    public List<Customer> findAllCustomer() {
         EntityManager em = null;;
        EntityTransaction tx = null;

        try {
           em=JPAUtil.creatEntityManager();
           tx = em.getTransaction();

            tx.begin();
            List<Customer> customerList = customerDao.findAllCustomer();
             tx.commit();
            return  customerList;
        }catch (Exception e){
          tx.rollback();
            throw new RuntimeException(e);
        }




    }

    @Override
    public void insertCustomer(Customer customer) {






            customerDao.insertCustomer(customer);




    }

}
